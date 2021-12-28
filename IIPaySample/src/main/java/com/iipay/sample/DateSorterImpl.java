package com.iipay.sample;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

@Slf4j
public class DateSorterImpl implements DateSorter {

    //Not having this variable in a separate constants file since this is a specific implementation
    private final List<Month> rMonthList = List.of(Month.JANUARY, Month.FEBRUARY, Month.MARCH, Month.APRIL,
            Month.SEPTEMBER, Month.OCTOBER, Month.NOVEMBER, Month.DECEMBER);

    Comparator<LocalDate> rMonthComparator = (d1, d2) -> {
        if (d1.compareTo(d2) != 0) { //to handle the 1st comparison for nonR
            //incoming nonR and existing R month
            if (!rMonthList.contains(d1.getMonth()) && rMonthList.contains(d2.getMonth())) {
                return 1;
            }
            //both nonR
            else if (!rMonthList.contains(d1.getMonth()) && !rMonthList.contains(d2.getMonth())) {
                return d2.compareTo(d1);
            }
            //incoming R and existing nonR month
            else if (rMonthList.contains(d1.getMonth()) && !rMonthList.contains(d2.getMonth())) {
                return -1;
            }
        }
        return d1.compareTo(d2);
    };

    @Override
    public SortedSet<LocalDate> sortDates(Set<LocalDate> unsortedDates) {
        if (CollectionUtils.isEmpty(unsortedDates)) {
            log.info("No dates passed in the input");
            return new TreeSet<>();
        }
        SortedSet<LocalDate> set = new TreeSet<>(rMonthComparator);
        set.addAll(unsortedDates);
        return set;
    }
}
