package org.aashish.perfect.booking.core.spi;

import org.aashish.perfect.booking.api.dto.ShowSummaryDTO;

import java.util.List;

public interface MovieService {
    List<ShowSummaryDTO> findByMovieNameCity(String movieId, String cityId, String Date);
}
