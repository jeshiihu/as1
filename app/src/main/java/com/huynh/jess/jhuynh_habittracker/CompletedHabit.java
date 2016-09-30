package com.huynh.jess.jhuynh_habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by Jess on 2016-09-26.
 */

// Complete habit has 1 habit obj
public class CompletedHabit
{
    private Habit containedHabit;
    private Date  completeDate = new Date();
    private Boolean completed = Boolean.FALSE;

    public CompletedHabit(Habit habit)
    {
        containedHabit = habit;
    }

    public Habit getHabit()
    {
        return containedHabit;
    }

    public void setHabit(Habit habit)
    {
        containedHabit = habit;
    }

    public void complete()
    {
        completeDate = new Date(System.currentTimeMillis());
        completed = Boolean.TRUE;
    }

    public Boolean isCompleted()
    {
        return completed;
    }
}
