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
        for (Flight flight : flights) {
            if (flight.getSegments().get(0).getDepartureDate().isBefore(flight.getSegments().get(0).getArrivalDate())) {
                filteredFlights.add(flight);
            }
        }
        return filteredFlights;
    }
}
