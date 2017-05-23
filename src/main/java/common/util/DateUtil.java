package common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;

public class DateUtil {

	public static Date parseDateToGMT(Date date, String pattern) {
		Date parse = null;
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String format = sdf.format(date);
		//设置时区（东八区）
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTimeZone(new SimpleTimeZone(0, "GMT"));
		sdf.setCalendar(gregorianCalendar);
		try {
			parse = sdf.parse(format);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return parse;
	}
}
