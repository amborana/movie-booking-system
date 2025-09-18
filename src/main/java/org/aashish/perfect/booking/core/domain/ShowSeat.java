package org.aashish.perfect.booking.core.domain;

import lombok.Data;

@Data
public class ShowSeat {
    public enum Status { AVAILABLE, LOCKED, RESERVED }
    private final String showId;
    private final String seatId;
    private final Status status;
    private final long version;
}
