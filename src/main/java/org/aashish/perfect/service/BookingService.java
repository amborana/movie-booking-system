package org.aashish.perfect.service;

import org.aashish.perfect.dto.booking.BookingRequest;
import org.aashish.perfect.dto.booking.BookingResponse;
import org.aashish.perfect.model.Booking;
import org.springframework.stereotype.Service;


public interface BookingService {
    BookingResponse bookSeats(BookingRequest request);
    void cancelBooking(String bookingId, String userId);
    Booking getBooking(String bookingId);
}
