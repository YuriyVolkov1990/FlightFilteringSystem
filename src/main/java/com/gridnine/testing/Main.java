package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello passenger!");
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println("All flights = " + flights);

        Filter beforeCurrentTime = new DepartureBeforeCurrentTime();
        System.out.println("Исключение вылетов до текущего момента времени:" + beforeCurrentTime.filter(flights));

        Filter earlierDepartureDate = new ArrivalDateEarlierDepartureDate();
        System.out.println("Исключение перелётов с датой прилёта раньше даты вылета" + earlierDepartureDate.filter(flights));
    }
}