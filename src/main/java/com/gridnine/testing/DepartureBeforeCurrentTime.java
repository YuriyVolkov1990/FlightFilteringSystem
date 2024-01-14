package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *  Исключение перелётов до текущего момента времени
 */
public class DepartureBeforeCurrentTime implements Filter {
@Override
public List<Flight> filter(List<Flight> flights) {
    List<Flight> filteredFlights = new ArrayList<>();
    work:
    for (Flight flight : flights) {
        LocalDateTime now = LocalDateTime.now();
        for (int i = 0; i < flight.getSegments().size(); i++) {
            if (flight.getSegments().get(i).getDepartureDate().isBefore(now)) {
                continue work;
            }
        }
            filteredFlights.add(flight);
    }
    return filteredFlights;
}
}
