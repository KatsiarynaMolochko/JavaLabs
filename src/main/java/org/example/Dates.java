package org.example;
import java.text.ParseException;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;




public class Dates {

    Date date;
    Calendar calendar;
    public Dates(int year, int month, int day, int hr, int m, int sec){
        SimpleDateFormat format = new SimpleDateFormat("DD MM YYYY hh:mm::ss");
        try {
            format.setLenient(false);
            date = format.parse(day + " " + month + " " + year + " " + hr + ":" + m + ":" + sec);
            calendar = new GregorianCalendar(year, month, day);
        } catch (ParseException e) {
            date = new Date();
            calendar = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
        }
    }

    public Dates(String d, String f) {
        SimpleDateFormat format = new SimpleDateFormat(f);
        try {
            date = format.parse(d);
            calendar = new GregorianCalendar(date.getYear(), date.getMonth(), date.getDay());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public Integer getYear() {
        return calendar.get(GregorianCalendar.YEAR);
    }


    public Integer getMonth() {
        return calendar.MONTH;
    }


    public Integer getHour() {
        return calendar.HOUR;
    }


    public void printAllNumbers() {
        System.out.println(calendar.get(GregorianCalendar.DAY_OF_YEAR) + " " + calendar.DAY_OF_MONTH
                + " " + calendar.DAY_OF_WEEK);
    }


    public void printDate() {
        System.out.println(date.getDate() + " " + (date.getMonth() + 1) + " " + (date.getYear() + 1900));
    }


    public void printDateWithTime() {
        System.out.println(date);
    }


    public void printWithSimpleDateFormat() {
        SimpleDateFormat format = new SimpleDateFormat("YY MM d, FF неделя HH  hh:mm a, 'TimeZone:' Z");
        System.out.println(format.format(date));
    }


    public void printWithFormatter() {
        SimpleDateFormat sdf = new SimpleDateFormat("E");
        SimpleDateFormat mon = new SimpleDateFormat("MMM");
        SimpleDateFormat dayn = new SimpleDateFormat("D");

        String dayName = sdf.format(calendar.DAY_OF_WEEK);
        String monthName = mon.format(calendar.MONTH);
        String day = dayn.format(calendar.DAY_OF_YEAR);

        Formatter format = new Formatter();
        System.out.println(format.format("Name of Day: %s; Day in year: %d; Name of month: %s; DayAM/PM: %s; Time: %d:%d",
                dayName, day, monthName, date.getTime(), date.getHours(), date.getMinutes()));
    }


    public void setDate(int year, int month, int day) {
        date.setYear(year);
        date.setMonth(month);
        date.setDate(day);
        calendar = new GregorianCalendar(year, month, day);
    }


    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);

        System.out.println( "Input date format: " );
        String format = in.nextLine();

        System.out.println("Input date: ");
        String date = in.nextLine();



        Dates d = new Dates(date, format);
        d.printDate();
        d.printDateWithTime();
        System.out.println("Year: " + d.getYear());
        System.out.println("Month: " + d.getMonth());
        System.out.println("Hour: " + d.getHour());
        d.printAllNumbers();
        d.printWithSimpleDateFormat();
        d.setDate(1888, 11, 13);
        d.printWithFormatter();







    }
}

