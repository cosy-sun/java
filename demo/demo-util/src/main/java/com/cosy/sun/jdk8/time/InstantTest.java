package com.cosy.sun.jdk8.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;


public class InstantTest {

	public void test() {
		Instant instant = Instant.now();
		System.out.println(instant);
		
		LocalDate localdate = LocalDate.now();
		System.out.println(localdate);
		int year = localdate.getYear();
		Month month = localdate.getMonth(); 
		int dayOfMonth = localdate.getDayOfMonth();
		System.out.println(year+""+month.getValue()+""+dayOfMonth);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		int hour = localTime.getHour();
		int minute = localTime.getMinute();
		int second = localTime.getSecond();
		int nano = localTime.getNano();
		System.out.println(hour + "-" + minute + "-" + second + "-" + nano);
		
		ZonedDateTime zoneDateTimee = ZonedDateTime.now();
		System.out.println(zoneDateTimee);
		ZoneId zone = zoneDateTimee.getZone();
		System.out.println(zone);
		
		LocalDateTime localdatetime = LocalDateTime.now();
		int dayOfMonth2 = localdatetime.getDayOfMonth();
		DayOfWeek dayOfWeek = localdatetime.getDayOfWeek();
		System.out.println(dayOfWeek.getValue());
		System.out.println(dayOfMonth2);
		
		int i = localdatetime.get(ChronoField.AMPM_OF_DAY);
		System.out.println(i);
		int j = localdate.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH);
		System.out.println(j);
		
		LocalDateTime with = localdatetime.with(TemporalAdjusters.firstDayOfMonth());
		System.out.println(with);
		
	}
	
	//@Test
	public void test1() {
		Date date = new Date();
		Instant instant = date.toInstant();
		ZoneId systemDefault = ZoneId.systemDefault();
		LocalDateTime ofInstant = LocalDateTime.ofInstant(instant, systemDefault);
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyyMMdd hhMMss");
		String format = ofInstant.format(ofPattern);
		System.out.println(format);
	}
}
