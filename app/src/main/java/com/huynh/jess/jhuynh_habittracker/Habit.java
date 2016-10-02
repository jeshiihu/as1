package com.huynh.jess.jhuynh_habittracker;

import android.nfc.FormatException;

import java.io.InvalidClassException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * Created by Jess on 2016-09-24.
 */

public class Habit implements Serializable
{
    private String  habitTitle;
    private DaysSet setOfDays;
    private String  createdDate;
    private CompletedHabitList completedHabits = new CompletedHabitList();

    public Habit()
    {
        this.habitTitle = "";
    }

    public Habit(String title)
    {
        this.habitTitle = title;
    }

    @Override
    public String toString()
    {
        return habitTitle;
    }

    public void setTitle(String title)
    {
        this.habitTitle = title;
    }

    public String getTitle()
    {
        return this.habitTitle;
    }

    public void setDays(DaysSet days)
    {
        this.setOfDays = days;
    }

    public DaysSet getDays()
    {
        return this.setOfDays;
    }

    public void setCreatedDateByDate(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        createdDate = format.format(date);
    }

    public void setCreatedDateByStr(String dateStr)
    {
        createdDate = dateStr;
    }

    public Boolean isValidDate()
    {
        return createdDate.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public CompletedHabitList getCompletedHabits()
    {
        return completedHabits;
    }
}
