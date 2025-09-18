package org.aashish.perfect.booking.core.spi;

import org.aashish.perfect.booking.api.dto.BookingResponseDTO;

import java.util.List;

public interface BookingManagementService {
    BookingResponseDTO createBooking(String idempotencyKey, String userId, String showId, List<String> seatIds);
    BookingResponseDTO confirmBooking(String bookingId);       // transitions LOCKED -> RESERVED atomically
    BookingResponseDTO cancelBooking(String bookingId);        // releases seats if applicable
}