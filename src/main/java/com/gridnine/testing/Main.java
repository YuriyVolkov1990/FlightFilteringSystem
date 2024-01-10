package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello passenger!");
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("0: " + flights);

        Filter beforeCurrentTime = new DepartureBeforeCurrentTime();
        System.out.println("1: " + beforeCurrentTime.filter(flights));

        Filter earlierDepartureDate = new ArrivalDateEarlierDepartureDate();
        System.out.println("2: " + earlierDepartureDate.filter(flights));
    }
}