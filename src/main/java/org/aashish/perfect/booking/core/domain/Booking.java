package org.aashish.perfect.booking.core.domain;

import lombok.Data;

import java.util.List;

public record Booking(String id, String userId, String showId, List<String> seatIds,
                      org.aashish.perfect.booking.core.domain.Booking.Status status, String idempotencyKey) {
    public enum Status {PENDING, CONFIRMED, CANCELLED}

    public boolean pending() {
        return Status.PENDING.equals(status);
    }

    public boolean confirmed() {
        return Status.CONFIRMED.equals(status);
    }

    public boolean cancelled() {
        return Status.CANCELLED.equals(status);
    }
}
