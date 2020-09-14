package 練習;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Prac {
	public static void main(String[] args) {
		LocalDateTime d = LocalDateTime.now();
		System.out.println(d.getYear());//年
		System.out.println(d.getMonth());//月
		System.out.println(d.getDayOfMonth());//日
		System.out.println(d.getHour());//時間
		System.out.println(d.getMinute());//分
		System.out.println(d.getSecond());//秒
		System.out.println(d.getNano());//ナノ
		System.out.println(d.get(ChronoField.YEAR));
		String year = String.valueOf(d.getYear());
		String month = String.valueOf(d.getMonth());
		String day = String.valueOf(d.getDayOfMonth());

		if(month.equals("JANUARY")) {
			month = "01";
		} else if(month.equals("FEBRUARY")) {
			month = "02";
		} else if(month.equals("MARCH")) {
			month = "03";
		} else if(month.equals("APRIL")) {
			month = "04";
		} else if(month.equals("MAY")) {
			month = "05";
		} else if(month.equals("JUNE")) {
			month = "06";
		} else if(month.equals("JULY")) {
			month = "07";
		} else if(month.equals("AUGUST")) {
			month = "08";
		} else if(month.equals("SEPTEMBER")) {
			month = "09";
		} else if(month.equals("OCTOBER")) {
			month = "10";
		} else if(month.equals("NOVEMBER")) {
			month = "11";
		} else if(month.equals("DECEMBER")) {
			month = "12";
		}
		String today = year+month+day;
		System.out.println(today);
	}
}


