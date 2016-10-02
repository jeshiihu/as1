package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jess on 2016-09-26.
 */

public class CompletedHabit implements Serializable
{
    private String habitTitle;
    private String repeatedDays;
    private String dailyCompletions;
    private String totalCompletions;
    private Date  completeDate;

    public CompletedHabit(Habit habit)
    {
        completeDate = new Date(System.currentTimeMillis());
        habitTitle = habit.getTitle();
        repeatedDays = habit.getDays().toString();
        dailyCompletions = Integer.toString(habit.getCompletedHabits().getDailyCompletionsCount()+1);
        totalCompletions = Integer.toString(habit.getCompletedHabits().getTotalCompletionCount()+1);
    }

    @Override
    public String toString()
    {
        return habitTitle + "\n" + getCompletionDateTime();
    }

    public String getCompletionDate()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(completeDate);
    }

    public String getCompletionDateTime()
    {
        SimpleDateFormat format = new SimpleDateFormat("EEE yyyy-MM-dd, hh:mm::ss");
        return format.format(completeDate);
    }

    public Date getDate()
    {
        return completeDate;
    }

    public String getHabitTitle() {
        return habitTitle;
    }

    public String getRepeatedDays() {
        return repeatedDays;
    }

    public String getDailyCompletions() {
        return dailyCompletions;
    }

    public String getTotalCompletions() {
        return totalCompletions;
    }
}
