package org.aashish.perfect.booking.core.spi;

import org.aashish.perfect.booking.core.domain.ShowSeat;

import java.util.List;

public interface ShowSeatRepository {
    boolean reserveSeatsAtomically(String showId, List<String> seatIds);
    List<ShowSeat> findByShow(String showId);

}
