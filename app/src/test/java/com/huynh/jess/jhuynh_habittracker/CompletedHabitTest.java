package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-30.
 */

public class CompletedHabitTest
{
    private Habit initTestHabit()
    {
        Habit habit = new Habit("Bake cookies");
        habit.setCreatedDateByStr("2013-11-02");

        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Monday);
        habit.setDays(days);

        return habit;
    }

    @Test
    public void testHabitTitle()
    {
        CompletedHabit c = new CompletedHabit(initTestHabit());
        assert(c.getHabitTitle().equals("Bake cookies"));
    }

    @Test
    public void testHabitDays()
    {
        CompletedHabit c = new CompletedHabit(initTestHabit());
        assert(c.getRepeatedDays().equals("Monday"));
    }

    @Test
    public void testHabitCompletionDate()
    {
        Date date = new Date(System.currentTimeMillis());
        CompletedHabit c = new CompletedHabit(initTestHabit());
        assert(c.getDate().equals(date));
    }
}
