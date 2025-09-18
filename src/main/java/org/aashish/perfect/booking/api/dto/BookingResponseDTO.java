package org.aashish.perfect.booking.api.dto;

import lombok.Data;
import org.aashish.perfect.booking.core.domain.Booking;

@Data
public class BookingResponseDTO {
    private String bookingId;
    private Booking.Status status;
}
