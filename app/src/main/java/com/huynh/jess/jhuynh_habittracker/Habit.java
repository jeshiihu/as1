package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

// Code referenced from: Aleks Gekht
// http://stackoverflow.com/questions/26703691/android-return-object-as-a-activity-result
// this class needs to be serializable or parcelable in order to be returned from activiy

public class Habit implements Serializable
{
    private double  habitId;
    private String  habitTitle;
    private Date  habitCreationDate;
    private Boolean completed;
    private int     timesCompleted;

    public Habit(double id, String title, Date date)
    {
        this.habitId = id;
        this.habitTitle = title;
        this.habitCreationDate = date;
        this.completed = Boolean.FALSE;
    }

    @Override
    public String toString()
    {
        return habitTitle;
    }

    public double GetId()
    {
        return this.habitId;
    }

    public String GetTitle()
    {
        return this.habitTitle;
    }

    public Date GetDate()
    {
        return this.habitCreationDate;
    }

    public int GetTimesCompleted()
    {
        return this.timesCompleted;
    }


    public void complete()
    {
        this.completed = Boolean.TRUE;
        this.timesCompleted += 1;
    }

    public Boolean isCompleted()
    {
        return this.completed;
    }
}
