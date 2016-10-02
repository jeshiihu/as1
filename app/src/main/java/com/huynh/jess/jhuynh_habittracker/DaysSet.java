package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jess on 2016-09-26.
 */

public class DaysSet implements Serializable
{
    public enum Day
    {
        Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
    }

    private Set<Day> days;
    private String   currentDate;

    public DaysSet()
    {
        days = new HashSet<Day>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = format.format(new Date(System.currentTimeMillis()));
    }

    @Override
    public String toString()
    {
        //TODO: fix days to sort
        if(days.isEmpty())
            return "";

        String daysStr = "";
        for(Day d : days)
        {
            daysStr += d.name() + ", ";
        }

        return daysStr;
    }

    public void setCurrentDateByDate(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        currentDate = format.format(date);
    }

    public void setCurrentDateByStr(String dateStr) throws Exception
    {
        if(dateStr.matches("\\d{4}-\\d{2}-\\d{2}"))
            currentDate = dateStr;
        else
            throw new IllegalArgumentException();
    }

    public String getCurrentDate()
    {
        return currentDate;
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

    public Boolean isDayContained(String day)
    {
        try
        {
            Day dayEnum = Day.valueOf(day);
            return !days.isEmpty() && days.contains(dayEnum);
        }
        catch(Exception e)
        {
            throw new IllegalArgumentException();
        }

    }


    public int size()
    {
        return days.size();
    }

    public Boolean isEmpty()
    {
        return days.isEmpty();
    }
}
