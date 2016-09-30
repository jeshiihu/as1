package com.huynh.jess.jhuynh_habittracker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jess on 2016-09-29.
 */
public class HabitCreatorManager
{

    private String habitTitle = "";
    private String creationDate = "";
    private DaysSet days = new DaysSet();

    public HabitCreatorManager()
    {
        setCreatedDateByDate(new Date(System.currentTimeMillis()));
    }

    public void setTitle(String title)
    {
        habitTitle = title;
    }

    public String getTitle()
    {
        return habitTitle;
    }

    public void setCreatedDateByDate(Date date)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        creationDate = format.format(date);
    }

    public void setCreatedDateByStr(String dateStr)
    {
        creationDate = dateStr;
    }

    public String getCreatedDate()
    {
        return creationDate;
    }

    public void setDaysSet(DaysSet daySet)
    {
        days = daySet;
    }

    public DaysSet getDaysSet()
    {
        return days;
    }

    public Boolean isValidTitle()
    {
        return !habitTitle.isEmpty();
    }

    public Boolean isValidDate()
    {
        return creationDate.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    public Boolean isValidRepeatSelection()
    {
        return !days.isEmpty();
    }

    public Habit generateCreatedHabit()
    {
        // safety precaution
        if(isValidTitle() && isValidDate() && isValidRepeatSelection())
        {
            Habit habit = new Habit(habitTitle);
            habit.setDays(days);
            habit.setCreatedDateByStr(creationDate);

            return habit;
        }

        return new Habit();
    }
}
