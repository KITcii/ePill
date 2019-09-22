package com.doccuty.epill.userdrugplan;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

	public static Date asDateStartOfDay(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date asDateStartOfDay(Date date) {
		final LocalDate localDate = DateUtils.asLocalDate(date);
		return DateUtils.asDateStartOfDay(localDate);
	}

	public static Date asDateEndOfDay(LocalDate localDate) {
		return java.sql.Timestamp.valueOf(localDate.atTime(LocalTime.MAX));
	}

	public static Date asDateEndOfDay(Date date) {
		final LocalDate localDate = DateUtils.asLocalDate(date);
		return DateUtils.asDateEndOfDay(localDate);
	}

	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}

	public static Date setHoursOfDate(Date date, int hours) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, hours);
		final Date newDate = calendar.getTime();
		return newDate;
	}

	public static int getHours(Date datetimeIntakePlanned) {
		final Calendar calendar = GregorianCalendar.getInstance();
		calendar.setTime(datetimeIntakePlanned);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

}