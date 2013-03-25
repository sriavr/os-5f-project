package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static Calendar date_parse(String str) {
		Calendar cal = Calendar.getInstance();

		String str1, str2, str3;
		Date date = null;
		DateFormat formatter;
		str.substring(6);

		str1 = str_piece(str, ':', 1);
		str2 = str_piece(str, ',', 2);
		str2.trim();
		str3 = str_piece(str2, '-', 1);
		str3.trim();
		System.out.println(str3);

		try {

			formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
			date = (Date) formatter.parse(str3);
			System.out.println("In date format\n " + date);
		} catch (ParseException e) {
			System.out.println("Exception :" + e);
		}

		cal.setTime(date);
		return cal;

	}

	public static String str_piece(String str, char separator, int index) {
		String str_result = "";
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				count++;
				if (count == index) {
					break;
				}
			} else {
				if (count == index - 1) {
					str_result += str.charAt(i);
				}
			}
		}
		return str_result;
	}
}
