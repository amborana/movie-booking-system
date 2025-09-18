package org.aashish.perfect.booking.core.spi;

public interface IdempotencyStore {
    java.util.Optional<String> getBookingId(String idemKey);
    void remember(String idemKey, String bookingId, java.time.Duration ttl);
}