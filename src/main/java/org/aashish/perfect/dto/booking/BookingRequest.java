package org.aashish.perfect.dto.booking;

import lombok.Data;
import org.aashish.perfect.dto.audi.SeatsDTO;

import java.util.List;

@Data
public class BookingRequest {
    private int showId;
    private int userId;
    private List<SeatsDTO> seatsDTOS;
}
