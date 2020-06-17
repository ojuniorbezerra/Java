package date;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Created by Junior on 17/06/2020.
 */
public class LocalDateExample {

    public static void main(String[] args ){

        LocalDate localDate = LocalDate.now();

        System.out.println(localDate);
        System.out.println("Day of week " + localDate.getDayOfWeek().name());
        System.out.println("Day of week " + localDate.getDayOfWeek().ordinal());
        System.out.println("Month " + localDate.getMonth().getValue());
        System.out.println("Month " + localDate.getMonthValue());
        System.out.println("Year " + localDate.getYear());


        LocalDate localDate1 = LocalDate.of(2012,5,15);
        System.out.println("Month " + localDate1.getMonthValue());
        System.out.println("Year " + localDate1.getYear());

        LocalDate localDate2 = LocalDate.parse("2015-05-10");
        System.out.println("Month " + localDate2.getMonthValue());
        System.out.println("Year " + localDate2.getYear());

        System.out.println("Day of Month " + localDate2.plusDays(5).getDayOfMonth()); //Immutable
        System.out.println("Day of Month " + localDate2.getDayOfMonth());


        System.out.println(LocalDate.parse("2016-06-12").atStartOfDay());
        System.out.println(LocalDate.parse("2016-06-12").with(TemporalAdjusters.firstDayOfMonth()));
        System.out.println(LocalDate.parse("2016-06-12").with(TemporalAdjusters.lastDayOfMonth()));


        System.out.println(LocalDate.parse("2016-06-12").isAfter(LocalDate.of(2018, 4, 11)));
        System.out.println(LocalDate.parse("2016-06-12").isBefore(LocalDate.of(2018, 4, 11)));

    }
}

