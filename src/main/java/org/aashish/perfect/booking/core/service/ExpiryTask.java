package org.aashish.perfect.booking.core.service;

import lombok.Data;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
@Data
public class ExpiryTask implements Delayed {
    private final String showId, seatId;
    private final long expiresAtMs;
    private final long generation; // snapshot when scheduled

    ExpiryTask(String showId, String seatId, long expiresAtMs, long generation) {
        this.expiresAtMs=expiresAtMs;
        this.showId=showId;
        this.seatId=seatId;
        this.generation=generation;
    }

    @Override public long getDelay(TimeUnit unit) {
        long d = expiresAtMs - System.currentTimeMillis();
        return unit.convert(d, TimeUnit.MILLISECONDS);
    }
    @Override public int compareTo(Delayed o) {
        return Long.compare(this.expiresAtMs, ((ExpiryTask)o).expiresAtMs);
    }



}
