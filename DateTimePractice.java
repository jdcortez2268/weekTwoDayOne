//1.	 Which class would you use to store your birthday in years, months, days, seconds, and nanoseconds?
//LocalDateTime class
//
//2.	 Given a random date, how would you find the date of the previous Thursday?
//TemporalAdjuster.previous(DayOfWeek.THURSDAY)
//
//3.	 What is the difference between a ZoneId and a ZoneOffset?
//-Each time zone has identifier and offset from UTC/Greenwich, however ZoneOffset tracks the absolute offset from UTC/Greenwich
//-Also, a ZoneId provides rules for converting between an Instant and a LocalDateTime
//
//4.	 How would you convert an Instant to a ZonedDateTime? How would you convert a ZonedDateTime to an Instant?
//-ZonedDateTime newTime = instant.atZone(ZoneId.of(“identifier”)
//-Instant newInstant = ZonedDateTime.now().toInstant()
//

import java.time.Year;
import java.time.Month;
import java.time.YearMonth;
import java.time.LocalDate;
import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;


public class DateTimePractice {
	public static void main(String args[]) {
	//first example is that for a given year, reports the length of each month within that year
	int yearInput = 2019;
	for(Month month : Month.values()) {
        YearMonth ym = YearMonth.of(yearInput, month);
        System.out.println("The month of "+ month +" has "+ ym.lengthOfMonth() + " days");
    }
	
	//second example is that for a given month of the current year, lists all of mondays in month
	Month month = Month.APRIL;
	LocalDate date = Year.now().atMonth(month).atDay(1).with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
	
	//stays true while currentMonth is still April
	Month currentMonth = date.getMonth();
	while (currentMonth == month) {
		System.out.println(" The date of this monday is : " + date);
		
		//go to next monday and reset currentMonth variable
		date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		currentMonth = date.getMonth();
	}
	
	//third example is to test whether a given date occurs on friday the 13th
	//first sample date is a date that does occur on friday the 13th
	//second sample date is a date that does not occur on friday the 13th
	
	String firstDate =  "2020-03-13";
	String secondDate = "2020-04-21";
	
	LocalDate ld = LocalDate.parse(firstDate);
	DayOfWeek dayOfWeek = ld.getDayOfWeek();
	int dayOfMonth= ld.getDayOfMonth();
	if(dayOfWeek == DayOfWeek.FRIDAY && dayOfMonth == 13)
	{
		System.out.println("Friday the 13th occurred on " + ld);
	}else {
		System.out.println("Friday the 13th did not occur on " + ld);
	}
	
	LocalDate localDateTwo = LocalDate.parse(secondDate);
	DayOfWeek dayOfWeekTwo = localDateTwo.getDayOfWeek();
	int dayOfMonthTwo= localDateTwo.getDayOfMonth();
	if(dayOfWeekTwo == DayOfWeek.FRIDAY && dayOfMonthTwo == 13)
	{
		System.out.println("Friday the 13th occurred on " + localDateTwo);
	}else {
		System.out.println("Friday the 13th did not occur on " + localDateTwo);
	}
}
}
