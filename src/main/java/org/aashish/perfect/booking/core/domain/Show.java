package org.aashish.perfect.booking.core.domain;

import lombok.Data;

@Data
public class Show {
    private final String id;
    private final String screenId;
    private final String movieId;
    private final long startsAtEpochMsUtc;
    private final long endsAtEpochMsUtc;
}
