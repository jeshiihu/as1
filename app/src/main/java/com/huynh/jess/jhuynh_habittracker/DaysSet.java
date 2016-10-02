package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
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

    public DaysSet()
    {
        days = new HashSet<Day>();
    }

    @Override
    public String toString()
    {
        if(days.isEmpty())
            return "";

        String daysStr = "";
        for(Day d : days)
        {
            daysStr += d.name() + ", ";
        }
        daysStr = daysStr.substring(0, daysStr.length()-2);

        return daysStr;
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
