package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello passenger!");
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights = " + flights);

        Filter first = new DepartureBeforeCurrentTime();

        System.out.println("Без вылета до текущего момента времени:" + first.filter(flights));
    }
}