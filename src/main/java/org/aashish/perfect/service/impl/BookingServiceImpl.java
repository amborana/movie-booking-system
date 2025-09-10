package org.aashish.perfect.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.aashish.perfect.dto.ShowDTO;
import org.aashish.perfect.dto.ShowsRegistry;
import org.aashish.perfect.dto.audi.SeatsDTO;
import org.aashish.perfect.dto.booking.BookingRequest;
import org.aashish.perfect.dto.booking.BookingResponse;
import org.aashish.perfect.init.ShowCreationInit;
import org.aashish.perfect.model.Booking;
import org.aashish.perfect.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class BookingServiceImpl implements BookingService {
    @PostConstruct
    public void init() {
        ShowCreationInit.initializeTheaterWithShows();
    }

    @Override
    @Transactional
    public BookingResponse bookSeats(BookingRequest request) {
        ShowDTO show = ShowsRegistry.getShow(request.getShowId());
        var userId = request.getUserId();
        if (show == null) {
            return new BookingResponse(Boolean.FALSE, "Show not available");
        }
        // Keep track of seats we successfully booked in this transaction
        List<SeatsDTO> reservedSeats = new ArrayList<>();
        for (SeatsDTO reqSeat : request.getSeatsDTOS()) {
            SeatsDTO seat = show.getSeatingStatus()
                    .getSeatRows()
                    .get(reqSeat.getRow())
                    .get(reqSeat.getColumn());

            // Try to atomically reserve
            boolean reserved = seat.getBooked().compareAndSet(false, true);
            if (!reserved) {
                // Rollback any seats reserved in this booking
                for (SeatsDTO s : reservedSeats) {
                    s.getBooked().set(false);
                    s.setUserId(null);
                }
                return new BookingResponse(Boolean.FALSE, "One or more seats already booked. Booking failed.");
            }
            // Mark as reserved for rollback, set userId after all succeed
            reservedSeats.add(seat);
        }
        // All seats successfully reserved—now set userId
        reservedSeats.forEach(seat -> seat.setUserId(userId));

        return new BookingResponse(Boolean.TRUE, "Booking done");
    }


    @Override
    public void cancelBooking(String bookingId, String userId) {
//            List<SeatsDTO> seatsDTOS=ShowsRegistry.getShowMap()
    }

    @Override
    public Booking getBooking(String bookingId) {
        return null;
    }
}
