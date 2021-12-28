package com.iipay.sample;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DateSorterImplTest {

    DateSorter dateSorter = new DateSorterImpl();

    @Test
    void testDateSorterWithOnlyRMonths() {
        List<LocalDate> expectedList = new ArrayList<>();
        expectedList.add(LocalDate.of(2019, 1, 2));
        expectedList.add(LocalDate.of(2019, 2, 1));
        expectedList.add(LocalDate.of(2019, 3, 1));
        expectedList.add(LocalDate.of(2019, 4, 3));
        expectedList.add(LocalDate.of(2019, 10, 8));
        expectedList.add(LocalDate.of(2019, 11, 13));


        Set<LocalDate> unSortedSet = Stream.of(LocalDate.of(2019, 10, 8),
                        LocalDate.of(2019, 3, 1),
                        LocalDate.of(2019, 1, 2),
                        LocalDate.of(2019, 2, 1),
                        LocalDate.of(2019, 4, 3),
                        LocalDate.of(2019, 11, 13))
                .collect(Collectors.toCollection(HashSet::new));


        SortedSet<LocalDate> actual = dateSorter.sortDates(unSortedSet);
        int i = 0;
        for (LocalDate date : actual) {
            assertEquals(date, expectedList.get(i));
            i++;
        }
    }

    @Test
    void testDateSorterWithSampleData() {
        List<LocalDate> expectedList = new ArrayList<>();
        expectedList.add(LocalDate.of(2019, 1, 1));
        expectedList.add(LocalDate.of(2019, 1, 2));
        expectedList.add(LocalDate.of(2019, 7, 1));
        expectedList.add(LocalDate.of(2019, 5, 3));

        Set<LocalDate> unSortedSet = Stream.of(LocalDate.of(2019, 7, 1),
                        LocalDate.of(2019, 1, 2),
                        LocalDate.of(2019, 1, 1),
                        LocalDate.of(2019, 5, 3))
                .collect(Collectors.toCollection(HashSet::new));


        SortedSet<LocalDate> actual = dateSorter.sortDates(unSortedSet);
        int i = 0;
        for (LocalDate date : actual) {
            assertEquals(date, expectedList.get(i));
            i++;
        }
    }

    @Test
    void testDateSorterWithOnlyNonRMonths() {
        List<LocalDate> expectedList = new ArrayList<>();
        expectedList.add(LocalDate.of(2019, 8, 2));
        expectedList.add(LocalDate.of(2019, 7, 1));
        expectedList.add(LocalDate.of(2019, 6, 1));
        expectedList.add(LocalDate.of(2019, 5, 3));

        Set<LocalDate> unSortedSet = Stream.of(LocalDate.of(2019, 5, 3),
                        LocalDate.of(2019, 8, 2),
                        LocalDate.of(2019, 6, 1),
                        LocalDate.of(2019, 7, 1))
                .collect(Collectors.toCollection(HashSet::new));

        SortedSet<LocalDate> actual = dateSorter.sortDates(unSortedSet);
        int i = 0;
        for (LocalDate date : actual) {
            assertEquals(date, expectedList.get(i));
            i++;
        }
    }

    @Test
    void testDateSorterWithFirstOfEveryMonth() {
        List<LocalDate> expectedList = new ArrayList<>();
        expectedList.add(LocalDate.of(2019, 1, 1));
        expectedList.add(LocalDate.of(2019, 2, 1));
        expectedList.add(LocalDate.of(2019, 3, 1));
        expectedList.add(LocalDate.of(2019, 4, 1));
        expectedList.add(LocalDate.of(2019, 9, 1));
        expectedList.add(LocalDate.of(2019, 10, 1));
        expectedList.add(LocalDate.of(2019, 11, 1));
        expectedList.add(LocalDate.of(2019, 12, 1));
        expectedList.add(LocalDate.of(2019, 8, 1));
        expectedList.add(LocalDate.of(2019, 7, 1));
        expectedList.add(LocalDate.of(2019, 6, 1));
        expectedList.add(LocalDate.of(2019, 5, 1));


        Set<LocalDate> unSortedSet = Stream.of(LocalDate.of(2019, 12, 1),
                        LocalDate.of(2019, 11, 1),
                        LocalDate.of(2019, 10, 1),
                        LocalDate.of(2019, 9, 1),
                        LocalDate.of(2019, 8, 1),
                        LocalDate.of(2019, 7, 1),
                        LocalDate.of(2019, 6, 1),
                        LocalDate.of(2019, 5, 1),
                        LocalDate.of(2019, 4, 1),
                        LocalDate.of(2019, 3, 1),
                        LocalDate.of(2019, 2, 1),
                        LocalDate.of(2019, 1, 1))
                .collect(Collectors.toCollection(LinkedHashSet::new));


        SortedSet<LocalDate> actual = dateSorter.sortDates(unSortedSet);
        int i = 0;
        for (LocalDate date : actual) {
            assertEquals(date, expectedList.get(i));
            i++;
        }
    }

    @Test
    void testDateSorterWithNull() {
        SortedSet<LocalDate> actual = dateSorter.sortDates(null);
        assertNotNull(actual);
        assertEquals(0, actual.size());
    }

    @Test
    void testDateSorterWithEmptySet() {
        SortedSet<LocalDate> actual = dateSorter.sortDates(new HashSet<>());
        assertNotNull(actual);
        assertEquals(0, actual.size());
    }

    @Test
    void testDateSorterWithMultipleYears() {
        List<LocalDate> expectedList = new ArrayList<>();
        expectedList.add(LocalDate.of(2019, 1, 2));
        expectedList.add(LocalDate.of(2019, 2, 1));
        expectedList.add(LocalDate.of(2019, 10, 1));
        expectedList.add(LocalDate.of(2020, 4, 3));
        expectedList.add(LocalDate.of(2019, 7, 8));
        expectedList.add(LocalDate.of(2019, 6, 13));


        Set<LocalDate> unSortedSet = Stream.of(LocalDate.of(2019, 7, 8),
                        LocalDate.of(2019, 10, 1),
                        LocalDate.of(2019, 1, 2),
                        LocalDate.of(2019, 2, 1),
                        LocalDate.of(2020, 4, 3),
                        LocalDate.of(2019, 6, 13))
                .collect(Collectors.toCollection(HashSet::new));


        SortedSet<LocalDate> actual = dateSorter.sortDates(unSortedSet);
        int i = 0;
        for (LocalDate date : actual) {
            assertEquals(date, expectedList.get(i));
            i++;
        }
    }
}