package org.aashish.perfect.booking.api.dto;

import org.aashish.perfect.booking.core.domain.ShowSeat;

import java.util.List;


public record AvailabilityDTO(
    String showId,
    String theatreId,
    String screenId,
     List<ShowSeat> availableSeats
){}
