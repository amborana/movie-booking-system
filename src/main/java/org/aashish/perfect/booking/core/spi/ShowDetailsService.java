package org.aashish.perfect.booking.core.spi;

import org.aashish.perfect.booking.api.dto.AvailabilityDTO;

public interface ShowDetailsService {
    AvailabilityDTO availability(String showId,String theaterId);
}
