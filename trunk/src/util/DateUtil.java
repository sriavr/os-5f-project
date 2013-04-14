package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

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
			//System.out.println("In date format\n " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		cal.setTime(date);
		return cal;

	}
	
	public static Date dateParse(String str) {
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
			//System.out.println("In date format\n " + date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
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

	public static Pattern getDateTimePattern() {
		String re1 = "((?:[a-z][a-z]+))"; // Word 1
		String re2 = "(:)"; // Any Single Character 1
		String re3 = "(\\s+)"; // White Space 1
		String re4 = "(Mon|Tue|Wed|Thu|Fri|Sat|Sun)"; // Day Of Week 1
		String re5 = "(,)"; // Any Single Character 2
		String re6 = "(\\s+)"; // White Space 2
		String re7 = "((?:(?:[0-2]?\\d{1})|(?:[3][01]{1})))(?![\\d])"; // Day 1
		String re8 = "(\\s+)"; // White Space 3
		String re9 = "((?:Jan(?:uary)?|Feb(?:ruary)?|Mar(?:ch)?|Apr(?:il)?|May|Jun(?:e)?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|Sept|Oct(?:ober)?|Nov(?:ember)?|Dec(?:ember)?))"; // Month
																																												// 1
		String re10 = "(\\s+)"; // White Space 4
		String re11 = "((?:(?:[1]{1}\\d{1}\\d{1}\\d{1})|(?:[2]{1}\\d{3})))(?![\\d])"; // Year
																						// 1
		String re12 = "(\\s+)"; // White Space 5
		String re13 = "((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)"; // HourMinuteSec
																															// 1
		String re14 = ".*?"; // Non-greedy match on filler
		String re15 = "(-)"; // Any Single Character 3
		String re16 = "(\\d)"; // Any Single Digit 1
		String re17 = "(\\d)"; // Any Single Digit 2
		String re18 = "(\\d)"; // Any Single Digit 3
		String re19 = "(\\d)"; // Any Single Digit 4
		String re20 = "(\\s+)"; // White Space 6
		String re21 = "(\\(.*\\))"; // Round Braces 1

		Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7
				+ re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16
				+ re17 + re18 + re19 + re20 + re21, Pattern.CASE_INSENSITIVE);
		return p;
	}
}
