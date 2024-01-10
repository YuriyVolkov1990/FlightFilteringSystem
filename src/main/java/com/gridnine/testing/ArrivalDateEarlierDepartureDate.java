package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;

/**
 * Исключение перелётов с датой прилёта раньше даты вылета
 */
public class ArrivalDateEarlierDepartureDate implements Filter {

    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        work:
        for (Flight flight : flights) {
            for (int j = 0; j < flight.getSegments().size(); j++) {
                if (flight.getSegments().get(j).getDepartureDate().isAfter(flight.getSegments().get(j).getArrivalDate())) {
                    continue work;
                }
            }
            filteredFlights.add(flight);
        }
        return filteredFlights;
    }
}