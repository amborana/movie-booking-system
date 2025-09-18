package org.aashish.perfect.booking.api.dto;

import lombok.Data;

@Data
public class ShowDTO {
    private final String id;
    private final String screenId;
    private final String movieId;
    private final long startsAtEpochMsUtc;
    private final long endsAtEpochMsUtc;
}
