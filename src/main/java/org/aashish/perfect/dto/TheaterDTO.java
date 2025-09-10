package org.aashish.perfect.dto;

import lombok.Data;
import org.aashish.perfect.dto.audi.AuditoriumDTO;

import java.util.Map;

@Data
public class TheaterDTO {
    private String theaterId;
    private Map<Integer, AuditoriumDTO> audiMap;
}
