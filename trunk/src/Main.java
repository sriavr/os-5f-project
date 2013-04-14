// URL that generated this code:
// http://txt2re.com/index-java.php3?s=Date:%20Wed,%2016%20May%202001%2020:42:00%20-0700%20(PDT)&8&-10&25&11&31&30&29&-73&28&-91&7&2&53&63&54&55&34&3&-74&32 

import java.io.IOException;
import java.util.Properties;
import java.util.regex.*;

import util.DateUtil;

class Main {
	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("myapp.properties"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String txt = properties.getProperty("date");
		// System.out.println("date:" + txt);

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

		// Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7
		// + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16
		// + re17 + re18 + re19 + re20 + re21, Pattern.CASE_INSENSITIVE
		// | Pattern.DOTALL);
		Pattern p = DateUtil.getDateTimePattern();
		Matcher m = p.matcher(txt);
		if (m.find()) {
			String word1 = m.group(1);
			String c1 = m.group(2);
			String ws1 = m.group(3);
			String dayofweek1 = m.group(4);
			String c2 = m.group(5);
			String ws2 = m.group(6);
			String day1 = m.group(7);
			String ws3 = m.group(8);
			String month1 = m.group(9);
			String ws4 = m.group(10);
			String year1 = m.group(11);
			String ws5 = m.group(12);
			String time1 = m.group(13);
			String c3 = m.group(14);
			String d1 = m.group(15);
			String d2 = m.group(16);
			String d3 = m.group(17);
			String d4 = m.group(18);
			String ws6 = m.group(19);
			String rbraces1 = m.group(20);
			System.out.print("(" + word1.toString() + ")" + "(" + c1.toString()
					+ ")" + "(" + ws1.toString() + ")" + "("
					+ dayofweek1.toString() + ")" + "(" + c2.toString() + ")"
					+ "(" + ws2.toString() + ")" + "(" + day1.toString() + ")"
					+ "(" + ws3.toString() + ")" + "(" + month1.toString()
					+ ")" + "(" + ws4.toString() + ")" + "(" + year1.toString()
					+ ")" + "(" + ws5.toString() + ")" + "(" + time1.toString()
					+ ")" + "(" + c3.toString() + ")" + "(" + d1.toString()
					+ ")" + "(" + d2.toString() + ")" + "(" + d3.toString()
					+ ")" + "(" + d4.toString() + ")" + "(" + ws6.toString()
					+ ")" + "(" + rbraces1.toString() + ")" + "\n");
			System.out.println("matched: " + m.group());
		}
	}
}
