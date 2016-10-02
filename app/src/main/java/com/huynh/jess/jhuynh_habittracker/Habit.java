package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;

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

    public void setCreatedDateByStr(String dateStr)
    {
        createdDate = dateStr;
    }

    public String getCreatedDate()
    {
        return createdDate;
    }

    public CompletedHabitList getCompletedHabits()
    {
        return completedHabits;
    }

    public Boolean isHabitCompletedToday()
    {
        if(getCompletedHabits().getDailyCompletionsCount() > 0)
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

    public void completeHabit()
    {
        CompletedHabit newCompletion = new CompletedHabit(this);
        getCompletedHabits().addCompletedHabit(newCompletion);
    }
}
