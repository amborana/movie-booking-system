package org.aashish.perfect.model;

import jakarta.persistence.Entity;
import org.aashish.perfect.dto.audi.SeatsDTO;

import java.util.List;

@Entity
public class Booking {
    private Integer userId;
    private Integer audiId;
    private Integer showId;
    private List<SeatsDTO> seatsDTOS;
}
