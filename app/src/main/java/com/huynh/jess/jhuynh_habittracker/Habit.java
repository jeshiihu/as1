package com.huynh.jess.jhuynh_habittracker;

import android.nfc.FormatException;

import java.io.Serializable;
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
    private String  habitCreationDate;
    private DaysSet setOfDays;

    public Habit()
    {
        this.habitTitle = "";
    }

    public Habit(String title, String date)
    {
        this.habitTitle = title;
        this.habitCreationDate = date;
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

    public void setDate(String date) throws Exception
    {
        if(!date.matches("\\d{4}-\\d{2}-\\d{2}"))
        {
            throw new FormatException();
        }

        this.habitCreationDate = date;
    }

    public String getDate()
    {
        return this.habitCreationDate;
    }

    public void setDays(DaysSet days)
    {
        this.setOfDays = days;
    }

    public DaysSet getDays()
    {
        return this.setOfDays;
    }
}
