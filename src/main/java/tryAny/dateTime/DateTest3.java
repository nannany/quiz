package tryAny.dateTime;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateTest3 {
    public static void main(String[] args) {
	LocalDateTime ldt1 = LocalDateTime.now();
	LocalDateTime ldt2 = ChronoUnit.DAYS.addTo(ldt1, 31);

	Duration d = Duration.between(ldt1, ldt2);
	Period p = Period.between(ldt1.toLocalDate(), ldt2.toLocalDate());

	System.out.println(d + " " + p);// PT744H P1M
    }
}
