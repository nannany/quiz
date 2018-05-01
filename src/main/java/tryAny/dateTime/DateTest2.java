package tryAny.dateTime;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

public class DateTest2 {
    public static void main(String[] args) {
	LocalDate ld1 = LocalDate.now();
	LocalDate ld2 = ChronoUnit.YEARS.addTo(ld1, -1);
	long l = ChronoUnit.DAYS.between(ld1, ld2);

	System.out.println(ld1);// 今
	System.out.println(ld2);// 今から一年前
	System.out.println(l);// 閏年等考慮しなければ-365
	System.out.println(ZoneId.systemDefault());// Asia/Tokyo
    }
}
