package com.huynh.jess.jhuynh_habittracker;

import java.text.SimpleDateFormat;
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

    public void setCurrentDate(Date date) {
        currentDate = date;
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
