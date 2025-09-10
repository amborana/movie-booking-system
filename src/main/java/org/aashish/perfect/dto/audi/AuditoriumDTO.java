package org.aashish.perfect.dto.audi;

import lombok.Data;

@Data
public class AuditoriumDTO {
    private String screenType;
    private int audiId;
    private String audiName;
    private SeatingArrangementDTO seatingArrangement;
}
