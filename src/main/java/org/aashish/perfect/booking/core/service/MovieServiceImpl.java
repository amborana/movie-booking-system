package org.aashish.perfect.booking.core.service;

import org.aashish.perfect.booking.api.dto.ShowDTO;
import org.aashish.perfect.booking.api.dto.ShowSummaryDTO;
import org.aashish.perfect.booking.core.spi.MovieService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MovieServiceImpl implements MovieService {
    @Override
    public List<ShowSummaryDTO> findByMovieNameCity(String movieId, String cityId, String Date) {
        return List.of();
    }
}
