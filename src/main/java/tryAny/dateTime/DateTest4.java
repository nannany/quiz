package tryAny.dateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateTest4 {
    public static void main(String[] args) {
	DateTimeFormatter dtf1 = DateTimeFormatter.BASIC_ISO_DATE;
	DateTimeFormatter dtf2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

	System.out.println(dtf1.format(LocalDate.now()));
	System.out.println(dtf2.format(LocalDateTime.now()));

	// オリジナルなフォーマットを作成
	DateTimeFormatter dtf3 = DateTimeFormatter.ofPattern("yyyy★MM★dd");
	System.out.println(dtf3.format(LocalDate.now()));
    }
}
