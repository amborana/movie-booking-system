package org.aashish.perfect.init;

import org.aashish.perfect.dto.*;
import org.aashish.perfect.dto.audi.AuditoriumDTO;
import org.aashish.perfect.dto.audi.SeatingArrangementDTO;
import org.aashish.perfect.dto.audi.SeatsDTO;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class ShowCreationInit {

        public static TheaterDTO initializeTheaterWithShows() {
            TheaterDTO theater = new TheaterDTO();
            theater.setTheaterId("KALAKAR-MALL-001");
            Map<Integer, AuditoriumDTO> audiMap = new HashMap<>();
            Map<Integer, ShowDTO> showMap = new HashMap<>();
            int showIdCounter = 1;

            // 3 Auditoriums
            for (int audiNum = 1; audiNum <= 3; audiNum++) {
                AuditoriumDTO auditorium = new AuditoriumDTO();
                auditorium.setAudiId(audiNum);
                auditorium.setAudiName("Audi-" + audiNum);
                auditorium.setScreenType(audiNum == 1 ? "Dolby Atmos" : "Dolby 7.1");

                SeatingArrangementDTO blueprint = createBlueprint(10, 12);
                auditorium.setSeatingArrangement(blueprint);

                audiMap.put(audiNum, auditorium);

                // 9 Shows per Audi
                for (int showSlot = 1; showSlot <= 9; showSlot++) {
                    ShowDTO show = new ShowDTO();
                    show.setShowId(showIdCounter++);
                    show.setMovieName("Movie-" + showSlot);
                    show.setShowTime(LocalDateTime.now().withHour(8 + showSlot).withMinute(0));
                    show.setAudiId(audiNum);
                    // Deep copy the blueprint for this show (fresh seat state)
                    show.setSeatingStatus(deepCopySeating(blueprint));
                    showMap.put(show.getShowId(), show);
                }
            }
            theater.setAudiMap(audiMap);

            // Store shows globally for booking
            ShowsRegistry.setShowMap(showMap); // Static registry class for booking lookup

            return theater;
        }

        // Helper: Blueprint creation
        private static SeatingArrangementDTO createBlueprint(int rowCount, int seatCount) {
            SeatingArrangementDTO arrangement = new SeatingArrangementDTO();
            Map<Character, Map<Integer, SeatsDTO>> seatRows = new HashMap<>();
            for (char row = 'A'; row < 'A' + rowCount; row++) {
                Map<Integer, SeatsDTO> seatMap = new HashMap<>();
                for (int col = 1; col <= seatCount; col++) {
                    SeatsDTO seat = new SeatsDTO();
                    seat.setRow(row);
                    seat.setColumn(col);
                    seat.setBooked(new AtomicBoolean(false));
                    seatMap.put(col, seat);
                }
                seatRows.put(row, seatMap);
            }
            arrangement.setSeatRows(seatRows);
            return arrangement;
        }

        // Helper: Deep copy seat blueprint for each show
        private static SeatingArrangementDTO deepCopySeating(SeatingArrangementDTO original) {
            SeatingArrangementDTO copy = new SeatingArrangementDTO();
            Map<Character, Map<Integer, SeatsDTO>> copyRows = new HashMap<>();
            for (Map.Entry<Character, Map<Integer, SeatsDTO>> rowEntry : original.getSeatRows().entrySet()) {
                Map<Integer, SeatsDTO> newRow = new HashMap<>();
                for (Map.Entry<Integer, SeatsDTO> seatEntry : rowEntry.getValue().entrySet()) {
                    SeatsDTO origSeat = seatEntry.getValue();
                    SeatsDTO seat = new SeatsDTO();
                    seat.setRow(origSeat.getRow());
                    seat.setColumn(origSeat.getColumn());
                    seat.setBooked(new AtomicBoolean(false));
                    newRow.put(seatEntry.getKey(), seat);
                }
                copyRows.put(rowEntry.getKey(), newRow);
            }
            copy.setSeatRows(copyRows);
            return copy;
        }
    }


