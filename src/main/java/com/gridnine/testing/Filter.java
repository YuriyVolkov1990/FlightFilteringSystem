package com.gridnine.testing;

import java.util.List;

interface Filter {
   List<Flight> filter(List<Flight> flights);
}
