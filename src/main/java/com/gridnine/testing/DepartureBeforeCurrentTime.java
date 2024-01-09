package com.gridnine.testing;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Вылет до текущего момента времени
 */
public class DepartureBeforeCurrentTime implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        for (Flight flight : flights) {
            LocalDateTime now = LocalDateTime.now();
            if (flight.getSegments().get(0).getDepartureDate().isAfter(now)) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
