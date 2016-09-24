package com.huynh.jess.jhuynh_habittracker;

import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class Habit
{
    private String habitTitle;
    private Date   habitCreationDate;

    public Habit(String title)
    {
        habitTitle = title;
        habitCreationDate = new Date(System.currentTimeMillis());
    }

    @Override
    public String toString()
    {
        return habitTitle;
    }
}
