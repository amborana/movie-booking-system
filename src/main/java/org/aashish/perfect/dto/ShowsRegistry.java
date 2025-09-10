package org.aashish.perfect.dto;

import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class ShowsRegistry {
    private static Map<Integer, ShowDTO> showMap = new HashMap<>();

    public static Map<Integer, ShowDTO> getShowMap() {
        return showMap;
    }

    public static void setShowMap(Map<Integer, ShowDTO> map) {
        showMap = map;
    }

    public static ShowDTO getShow(int showId) {
        return showMap.get(showId);
    }
}
