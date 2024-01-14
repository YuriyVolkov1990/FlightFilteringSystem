package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *  Исключение перелётов, где общее время, проведённое на земле, превышает два часа
 */
public class GroundTimeMoreThanTwoHours implements Filter {
    @Override
    public List<Flight> filter(List<Flight> flights) {
        List<Flight> filteredFlights = new ArrayList<>();
        work:
        for (int i = 0; i < flights.size(); i++) {
            long groundTimeCounter = 0;
            Flight flight = flights.get(i);
            for (int j = 0; j < flight.getSegments().size()-1; j++) {
                Segment segment = flight.getSegments().get(j);
                Segment nextSegment = flight.getSegments().get(j + 1);
                groundTimeCounter += segment.getArrivalDate().until(nextSegment.getDepartureDate(), ChronoUnit.HOURS);
                if (groundTimeCounter > 2) {
                    continue work;
                }
            }
            filteredFlights.add(flight);
        }
        return filteredFlights;
    }
}
