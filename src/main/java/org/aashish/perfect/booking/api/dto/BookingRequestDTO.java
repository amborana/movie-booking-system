package org.aashish.perfect.booking.api.dto;

import lombok.Data;

import java.util.List;

@Data
public class BookingRequestDTO {
    private String showId;
    private List<String> seats;
    private String theatreId;
}
