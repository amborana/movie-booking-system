package org.aashish.perfect.dto.audi;

import lombok.Data;

import java.util.Map;

@Data
public class SeatingArrangementDTO {
    private Map<Character, Map<Integer,SeatsDTO>> seatRows;
}
