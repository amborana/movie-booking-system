package org.aashish.perfect.booking.core.domain;

import lombok.Data;

public record SeatLock(String userId, long expiresAt) {
    public boolean isExpired(long nowMs) {
        return nowMs >= expiresAt;
    }
}
