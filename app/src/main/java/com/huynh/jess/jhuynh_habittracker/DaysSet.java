package com.huynh.jess.jhuynh_habittracker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jess on 2016-09-26.
 */

public class DaysSet
{
    public enum Day
    {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }

    private Set<Day> days;
    private Date     currentDate;

    public DaysSet()
    {
        days = new HashSet<Day>();
        currentDate = new Date();
    }

    public void setCurrentDateByDate(Date date) {
        currentDate = date;
    }

    public void setCurrentDateByStr(String dateStr) throws Exception
    {
        SimpleDateFormat validFormat = new SimpleDateFormat("yyyy-MM-dd");

        try
        {
            Date date = validFormat.parse(dateStr);

            Calendar cal = Calendar.getInstance();
            cal.setLenient(false);
            cal.setTime(date);
            cal.getTime();
        }
        catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }


    public String getCurrentDateStr(String s) {
        SimpleDateFormat format = new SimpleDateFormat(s);

        return format.format(currentDate);
    }

    public void addDay(Day day)
    {
        this.days.add(day);
    }

    public void removeDay(Day day)
    {
        this.days.remove(day);
    }

    public Boolean isDayContained(Day day)
    {
        return !days.isEmpty() && days.contains(day);
    }

    public int size()
    {
        return days.size();
    }

    public void setCurrentDay(Day day){
    }
}
