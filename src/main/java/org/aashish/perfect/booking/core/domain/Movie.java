package org.aashish.perfect.booking.core.domain;

import lombok.Data;

import java.util.Map;

@Data
public class Movie {
    private String id;
    private String movieName;
    private String rated; //A,UA,U etc
    private Map<String,Object> movieDetails; //more movie details can further be devided into child dtos
}
