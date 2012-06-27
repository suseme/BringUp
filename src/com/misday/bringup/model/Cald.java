package com.misday.bringup.model;

import java.util.Date;
import java.util.Calendar;

public class Cald {
	
	public class MiDate {
		public int year;
		public int month;
		public int day;
	}
	
	private Calendar mCalendar;
	private MiDate mDate;
	
	public Cald() {
		mCalendar = Calendar.getInstance();
		mDate = new MiDate();
		
		mDate.year = mCalendar.get(Calendar.YEAR);
		mDate.month = mCalendar.get(Calendar.MONTH);
		mDate.day = mCalendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public Cald(int year, int month, int day) {
		mCalendar = Calendar.getInstance();
		mDate = new MiDate();
		
		mDate.year = year;
		mDate.month = month;
		mDate.day = day;

		mCalendar.set(year, month, day);
	}
	
	public int fromToday() {
		Calendar today = Calendar.getInstance();
		
		return getIntervalDays(mCalendar, today);
	}
	
	public MiDate fromTodayH() {
		Cald today = new Cald();
		
		return getIntervalDate(this, today);
	}
	
	public static Date today() {
		return new Date();
	}
	
	private static int getIntervalDays(Cald start, Cald end) {
		return getIntervalDays(start.mCalendar, end.mCalendar);
	}
	
	private static int getIntervalDays(Calendar startday, Calendar endday){
		boolean isNeg = false;
		int absDays = 0;
		
		//exchange startday endday
		if (startday.after(endday)) {
			Calendar cal = startday;
			startday = endday;
			endday = cal;
			
			isNeg = true;
		}
		
		long sl = startday.getTimeInMillis();
		long el = endday.getTimeInMillis();

		long ei = el - sl;
		absDays = (int) (ei / (1000 * 60 * 60 * 24));
		return isNeg ? 0 - absDays : absDays;
	}
	
	private MiDate getIntervalDate(Cald start, Cald end) {
		Cald.MiDate date = new MiDate();
		
		if (start.mCalendar.after(end.mCalendar)) {
			return null;
		}
		
		//year
		date.year = end.mDate.year - start.mDate.year;
		
		//month
		if (end.mDate.month < start.mDate.month) {
			date.year--;
			date.month = end.mDate.month + 12 - start.mDate.month;
		} else {
			date.month = end.mDate.month - start.mDate.month;
		}
		
		//day
		if (end.mDate.day < start.mDate.day) {
			if (date.month == 0) {
				date.year--;
				date.month = 11;
			} else {
				date.month--;
			}
			
			date.day = end.mDate.day + getDaysOfMonth(end.mDate.year, end.mDate.month - 1) - start.mDate.day;
		} else {
			date.day = end.mDate.day - start.mDate.day;
		}
		
		return date;
	}
	
	public int getDaysOfMonth(int year, int month) {
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			return 31;
			
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
			
		case 2:
			return isLeapYear(year) ? 29 : 28; //TODO: leap year???
			
		default:
			return 30;
		}
	}
	
	public boolean isLeapYear(int year) {
		return (year%4 == 0 && year%100 != 0) || (year%400 == 0); 
	}
}
