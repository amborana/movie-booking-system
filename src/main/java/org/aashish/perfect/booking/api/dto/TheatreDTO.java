package org.aashish.perfect.booking.api.dto;

import lombok.Data;

@Data
public class TheatreDTO {
    private final String id;
    private final String name;
    private final String city;
    private final String timezone;
}
