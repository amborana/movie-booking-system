package org.aashish.perfect.dto;

import lombok.Data;
import org.aashish.perfect.dto.audi.SeatingArrangementDTO;

import java.time.LocalDateTime;

@Data
public class ShowDTO {
    private int showId;
    private String movieName;
    private LocalDateTime showTime;
    private int audiId;
    private SeatingArrangementDTO seatingStatus;
}
