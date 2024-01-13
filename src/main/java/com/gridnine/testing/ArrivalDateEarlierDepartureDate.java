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
            for (int i = 0; i < flight.getSegments().size(); i++) {
                if (flight.getSegments().get(i).getDepartureDate().isAfter(flight.getSegments().get(i).getArrivalDate())) {
                    continue work;
                }
            }
            filteredFlights.add(flight);
        }
        return filteredFlights;
    }
}