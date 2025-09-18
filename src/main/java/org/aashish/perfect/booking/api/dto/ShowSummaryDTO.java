package org.aashish.perfect.booking.api.dto;

import java.time.ZonedDateTime;

public record ShowSummaryDTO(
    String showId,
    String movieId,
    String theatreId,
    String theatreName,
    String screenId,
    String language,       // e.g., "hi-IN"
    String format,         // "2D","3D","IMAX"
    ZonedDateTime startsAtLocal,
    ZonedDateTime endsAtLocal,
    String timeZoneId      // IANA TZ of theatre
) {}