package org.aashish.perfect.booking.core.service;

import org.aashish.perfect.booking.core.domain.SeatLock;
import org.aashish.perfect.booking.core.spi.SeatLockBackend;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.DelayQueue;

@Component
public class SeatLockingImpl implements SeatLockBackend {
    private static final ConcurrentMap<String, ConcurrentMap<String, SeatLock>> locks = new ConcurrentHashMap<>();

    @Override
    public boolean acquire(String showId, List<String> seatIds, String userId, Duration ttl) {
        long now = System.currentTimeMillis();
        long expiresAt = now + ttl.toMillis();

        locks.putIfAbsent(showId, new ConcurrentHashMap<>());
        ConcurrentMap<String, SeatLock> bySeat = locks.get(showId);

        for (String seatId : seatIds) {
            SeatLock existing = bySeat.get(seatId);

            // treat expired as absent
            if (existing != null && existing.expiresAt() <= now) {
                bySeat.remove(seatId, existing);
                existing = null;
            }

            // if locked by another user → fail
            if (existing != null && !existing.userId().equals(userId)) {
                return false;
            }
        }

        // if all clear, put/refresh locks
        for (String seatId : seatIds) {
            bySeat.put(seatId, new SeatLock(userId, expiresAt));
        }
        return true;
    }

    @Override
    public void release(String showId, List<String> seatIds, String userId) {

    }

    @Override
    public boolean isOwned(String showId, List<String> seatIds, String userId) {
        return false;
    }

    @Override
    public void evictExpired() {

    }

    private final DelayQueue<ExpiryTask> expiredQ=new DelayQueue<>();
    {
        Thread sweeper=new Thread(()->{
            try {
                var expiryTask=expiredQ.take();
                var bySeat=locks.get(expiryTask.getSeatId());

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"seat-lock-sweeper");
        sweeper.start();
    }
}
