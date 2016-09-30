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
    private DaysSet setOfDays;

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
}
