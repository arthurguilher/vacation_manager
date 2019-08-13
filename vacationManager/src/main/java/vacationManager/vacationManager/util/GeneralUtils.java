package vacationManager.vacationManager.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;

public class GeneralUtils {

	public static String formatDate(Date date) {
		if (date == null) {
			return "";
		}
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String strDate = dateFormat.format(date);
		return strDate;
	}

	public static long daysBetweenDates(Date startDate, Date endDate) {
		return java.time.temporal.ChronoUnit.DAYS.between(
				startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
				endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
	}
}
