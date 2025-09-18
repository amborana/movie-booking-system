package org.aashish.perfect.booking.core.domain;

import lombok.Data;

@Data
public class Theatre {
    private final String id;
    private final String name;
    private final String city;
    private final String timezone;
}
