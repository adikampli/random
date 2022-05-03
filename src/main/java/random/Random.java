package random;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

public class Random {

    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        LocalDateTime datetime = LocalDateTime.now();
        System.out.println("Date: " + date
                + "\nTime: " + time +
                "\nDateTime: " + datetime +
                "\nDay Of Week: " + DayOfWeek.of(datetime.get(ChronoField.DAY_OF_WEEK)));

        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println(Duration.between(LocalTime.now().minusHours(1), LocalTime.now()).getSeconds());
        System.out.println(Period.between(LocalDate.now().minusWeeks(1), LocalDate.now()).getDays());

        System.out.println(LocalDate.parse("20211130", DateTimeFormatter.BASIC_ISO_DATE).getMonth());
    }

}
