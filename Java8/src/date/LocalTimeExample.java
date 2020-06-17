package date;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Created by Junior on 17/06/2020.
 */
public class LocalTimeExample {

    public static void main(String[] args ) {


        LocalTime localTime = LocalTime.of(10,48);

        System.out.println("Time " + localTime.plus(2, ChronoUnit.HOURS));
        System.out.println("Time " + localTime);//Immutable
        System.out.println("Hour " + localTime.getHour());
        System.out.println("Max Time " + LocalTime.MAX);
        System.out.println("IsAfter " + LocalTime.MAX.isAfter(localTime));//Immutable


    }
}
