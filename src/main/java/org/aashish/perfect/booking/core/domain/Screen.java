package org.aashish.perfect.booking.core.domain;

import lombok.Data;

@Data
public class Screen {
    private final String id;
    private final String theatreId;
    private final String name;
    private final String screenType;  // IMAX, 3D
    private final String soundProfile; //
}
