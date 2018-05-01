package tryAny.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTest1 {
    public static void main(String[] args) {
	LocalDateTime now = LocalDateTime.now();
	LocalDate ld1 = LocalDate.of(2018, Month.JANUARY, 1);
	LocalDate ld2 = LocalDate.parse("2018-01-02");
	LocalDate ld3 = LocalDate.from(now);

	System.out.println(now);
	System.out.println(ld1);
	System.out.println(ld2);
	System.out.println(ld3); // 時刻情報は失われている。
    }
}
