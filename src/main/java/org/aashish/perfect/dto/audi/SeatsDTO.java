package org.aashish.perfect.dto.audi;

import lombok.Data;

import java.util.concurrent.atomic.AtomicBoolean;

@Data
public class SeatsDTO {
    private Integer userId;
    private AtomicBoolean booked;
    private Integer column;
    private Character row;
}
