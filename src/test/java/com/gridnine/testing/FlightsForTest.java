package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Класс для создания тестовых перелётов
 */
public class FlightsForTest {
    private static final LocalDateTime CURRENT_DATE = LocalDateTime.now().plusDays(3);

    /**
     * Перелёт, состоящий из одного сегмента
     */
    public static Flight firstTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE, CURRENT_DATE.plusHours(2))
    ));

    /**
     * Перелёт, состоящий из двух сегментов
     */
    public static Flight secondTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE, CURRENT_DATE.plusHours(1)),
            new Segment(CURRENT_DATE.plusHours(2), CURRENT_DATE.plusHours(3))
    ));

    /**
     * Перелёт, где дата вылета раньше текущей даты
     */
    public static Flight thirdTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE.minusDays(4), CURRENT_DATE)
    ));

    /**
     * Перелёт, где дата прилёта раньше даты вылета
     */
    public static Flight fourthTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE, CURRENT_DATE.minusDays(1))
    ));

    /**
     * Перелёт, где общее время, проведённое на земле, не превышает два часа
     */
    public static Flight fifthTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE, CURRENT_DATE.plusHours(2)),
            new Segment(CURRENT_DATE.plusHours(3), CURRENT_DATE.plusHours(4))
    ));

    /**
     * Перелёт, где общее время, проведённое на земле, превышает два часа
     */
    public static Flight sixthTestFlight = new Flight(List.of(
            new Segment(CURRENT_DATE, CURRENT_DATE.plusHours(2)),
            new Segment(CURRENT_DATE.plusHours(3), CURRENT_DATE.plusHours(4)),
            new Segment(CURRENT_DATE.plusHours(6), CURRENT_DATE.plusHours(8))
    ));

    /**
     * Верные результаты фильтрации для проверки
     */
    public static List<Flight> allFlights = Arrays.asList(firstTestFlight, secondTestFlight, thirdTestFlight, fourthTestFlight, fifthTestFlight, sixthTestFlight);
    public static List<Flight> departureBeforeCurrentTime = Arrays.asList(firstTestFlight, secondTestFlight, fourthTestFlight, fifthTestFlight, sixthTestFlight);
    public static List<Flight> arrivalDateEarlierDepartureDate = Arrays.asList(firstTestFlight, secondTestFlight, thirdTestFlight, fifthTestFlight, sixthTestFlight);
    public static List<Flight> groundTimeMoreThanTwoHours = Arrays.asList(firstTestFlight, secondTestFlight, thirdTestFlight, fourthTestFlight, fifthTestFlight);
}
