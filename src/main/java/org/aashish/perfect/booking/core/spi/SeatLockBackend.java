package org.aashish.perfect.booking.core.spi;

import java.util.List;

public interface SeatLockBackend  {
    boolean acquire(String showId, List<String> seatIds, String userId, java.time.Duration ttl);
    void release(String showId, List<String> seatIds, String userId);
    boolean isOwned(String showId, List<String> seatIds, String userId);
    void evictExpired();
}
