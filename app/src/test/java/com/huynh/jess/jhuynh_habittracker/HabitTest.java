package com.huynh.jess.jhuynh_habittracker;

import android.nfc.FormatException;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HabitTest {

    private DaysSet createDays()
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Monday);
        days.addDay(DaysSet.Day.Wednesday);
        days.addDay(DaysSet.Day.Thursday);

        return days;
    }

    @Test
    public void getTitleEmpty() throws Exception
    {
        Habit habit = new Habit();
        assert(habit.getTitle().equals(""));
    }

    @Test
    public void setTitleValid() throws Exception
    {
        Habit habit = new Habit();
        habit.setTitle("Do Homework");
        assert(habit.getTitle().equals("Do Homework"));
    }

    @Test
    public void setDays() throws Exception
    {
        Habit habit = new Habit();
        habit.setDays(createDays());

        DaysSet days = habit.getDays();

        assert(days.size() == 3);
        assert(days.isDayContained(DaysSet.Day.Monday));
        assert(days.isDayContained(DaysSet.Day.Wednesday));
        assert(days.isDayContained(DaysSet.Day.Thursday));
    }
}