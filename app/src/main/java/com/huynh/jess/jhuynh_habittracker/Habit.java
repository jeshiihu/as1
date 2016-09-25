package com.huynh.jess.jhuynh_habittracker;

import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class Habit
{
    private String  habitTitle;
    private String  habitCreationDate;
    private Boolean completed;
    private int     timesCompleted;

    public Habit(String title, String date)
    {
        habitTitle = title;
        habitCreationDate = date;
        completed = Boolean.FALSE;
    }

    @Override
    public String toString()
    {
        return habitTitle;
    }

    public void complete()
    {
        completed = Boolean.TRUE;
        timesCompleted += 1;
    }

    public Boolean isCompleted()
    {
        return completed;
    }
}
