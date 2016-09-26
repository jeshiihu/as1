package com.huynh.jess.jhuynh_habittracker;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jess on 2016-09-26.
 */

public class DaysSet
{
    public enum Day
    {
        Sun, Mon, Tue, Wed, Thu, Fri, Sat
    }

    private Set<Day> days;

    public DaysSet()
    {
        days = new HashSet<Day>();
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
}
