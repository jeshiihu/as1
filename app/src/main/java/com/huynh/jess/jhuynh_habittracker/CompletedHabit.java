package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 * Created by Jess on 2016-09-26.
 */

public class CompletedHabit implements Serializable
{
    String habitTitle;
    String dateHabitWasCreated;
    private Date  completeDate;

    public CompletedHabit(String title, String createdDate)
    {
        completeDate = new Date(System.currentTimeMillis());
        habitTitle = title;
        dateHabitWasCreated = createdDate;
    }

    @Override
    public String toString()
    {
        return habitTitle + "\nCompleted on:" + getCompletionDateTime();
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
}
