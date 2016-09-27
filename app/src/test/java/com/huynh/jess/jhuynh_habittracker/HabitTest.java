package com.huynh.jess.jhuynh_habittracker;

import android.nfc.FormatException;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HabitTest {

    private DaysSet createDays()
    {
        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Mon);
        days.addDay(DaysSet.Day.Wed);
        days.addDay(DaysSet.Day.Thu);

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
    public void setDateValid() throws Exception
    {
        Habit habit = new Habit();
        habit.setDate("2016-09-22");
        assert(habit.getDate().equals("2016-09-22"));
    }

    @Test
    public void setDateInvalid() throws Exception
    {
        Habit habit = new Habit();
        Boolean caught = Boolean.FALSE;

        try {
            habit.setDate("2016 09 22"); // wrong format
        } catch(FormatException expException)
        {
            caught = Boolean.TRUE;
        }

        assert(caught);
    }

    @Test
    public void setDays() throws Exception
    {
        Habit habit = new Habit();
        habit.setDays(createDays());

        DaysSet days = habit.getDays();

        assert(days.size() == 3);
        assert(days.isDayContained(DaysSet.Day.Mon));
        assert(days.isDayContained(DaysSet.Day.Wed));
        assert(days.isDayContained(DaysSet.Day.Thu));
    }
}