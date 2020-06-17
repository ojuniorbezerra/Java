package date;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created by Junior on 17/06/2020.
 */
public class LocalDateTimeExample {

    public static void main(String[] args ) {

       String dateFormat  = LocalDateTime
                .of(2015, Month.FEBRUARY, 20, 06, 30)
                .plus(3, ChronoUnit.DAYS)
                .minus(32, ChronoUnit.HOURS)
               .format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

       System.out.print(dateFormat);
    }
}
