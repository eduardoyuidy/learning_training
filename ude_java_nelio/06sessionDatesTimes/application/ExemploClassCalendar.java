package application;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

public class ExemploClassCalendar {

	public static void main(String[] args) {
		
		/* Teste commit git bash */
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		Date d = Date.from(Instant.parse("2019-05-04T07:42:29Z"));

		System.out.println(sdf.format(d));

		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		cal.add(Calendar.HOUR_OF_DAY, 4); // Add 4 hours to the Date/Hour
		d = cal.getTime();

		// Extract Minute and Month values
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int month = 1 + cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);

		System.out.println(sdf.format(d));

		System.out.println("Day   : " + String.format("%02d", day));
		System.out.println("Month : " + String.format("%02d", month));
		System.out.println("Year  : " + String.format("%04d", year));
		System.out.println("Hour  : " + String.format("%02d", hour));
		System.out.println("Minute: " + String.format("%02d", minute));
		System.out.println("Second: " + String.format("%02d", second));
	}
}
