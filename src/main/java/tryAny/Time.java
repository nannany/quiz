package tryAny;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Time {
    public static void main(String[] args) {
	LocalDateTime lt1 = LocalDateTime.of(2015, 1, 1, 0, 0);
	LocalDateTime lt2 = LocalDateTime.of(2015, 1, 2, 0, 0);

	Duration d = Duration.between(lt1, lt2);
	System.out.println(d.toHours());
	long p = lt1.until(lt2, ChronoUnit.DAYS);
	System.out.println(p);

    }
}
