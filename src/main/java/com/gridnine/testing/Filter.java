package com.gridnine.testing;

import java.util.List;

/**
 * Интерфейс содержит метод для фильтрации полётов
 */
interface Filter {
   List<Flight> filter(List<Flight> flights);
}
