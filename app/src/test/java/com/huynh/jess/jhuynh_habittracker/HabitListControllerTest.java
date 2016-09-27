package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-26.
 */

public class HabitListControllerTest {

    private Habit habitFactory(String title)
    {
        Habit newHabit = new Habit();
        newHabit.setTitle(title);

        return newHabit;
    }

    @Test
    public void addHabitOneSize()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit = habitFactory("Cook dinner");

        habitControl.addHabit(habit);

        assert(habitControl.size() == 1);
    }

    @Test
    public void addHabitOneTitle()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit = habitFactory("Cook dinner");
        habitControl.addHabit(habit);
        Habit habitFromControl = habitControl.getHabit(0);

        assertSame(habitFromControl.getTitle(), "Cook dinner");
    }

    @Test
    public void addHabitMultipleSize()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit0 = habitFactory("Cook dinner");
        habitControl.addHabit(habit0);

        Habit habit1 = habitFactory("Run 20km");
        habitControl.addHabit(habit1);

        Habit habit2 = habitFactory("Relax for 5min");
        habitControl.addHabit(habit2);

        assert(habitControl.size() == 3);
    }

    @Test
    public void addHabitMultipleTitles()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit0 = habitFactory("Cook dinner");
        habitControl.addHabit(habit0);

        Habit habit1 = habitFactory("Run 20km");
        habitControl.addHabit(habit1);

        Habit habit2 = habitFactory("Relax for 5min");
        habitControl.addHabit(habit2);

        assertSame(habitControl.getHabit(2).getTitle(), "Relax for 5min");
        assertSame(habitControl.getHabit(1).getTitle(), "Run 20km");
        assertSame(habitControl.getHabit(0).getTitle(), "Cook dinner");
    }

    @Test
    public void getHabitInvalidIndex() throws Exception
    {
        HabitListController habitControl = new HabitListController();
        Boolean caught = Boolean.FALSE;

        try{
            habitControl.getHabit(0);
        }
        catch(IndexOutOfBoundsException exception)
        {
            caught = Boolean.TRUE;
        }

        assert(caught);
    }

    @Test
    public void removeHabitEmptySize() throws Exception
    {
        HabitListController habitControl = new HabitListController();
        Boolean caught = Boolean.FALSE;

        try {
            habitControl.removeHabit(0);
        }
        catch(IndexOutOfBoundsException exception)
        {
            caught = Boolean.TRUE;
        }

        assert(caught);
    }

    @Test
    public void removeHabitSize()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit = habitFactory("Cook dinner");
        habitControl.addHabit(habit);
        habitControl.removeHabit(0);

        assert(habitControl.size() == 0);
    }

    @Test
    public void removeHabitMultipleSize()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit0 = habitFactory("Cook dinner");
        habitControl.addHabit(habit0);

        Habit habit1 = habitFactory("Run 20km");
        habitControl.addHabit(habit1);
        habitControl.removeHabit(0);

        assert(habitControl.size() == 1);
    }

    @Test
    public void removeHabitMultipleTitle()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit0 = habitFactory("Cook dinner");
        habitControl.addHabit(habit0);

        Habit habit1 = habitFactory("Run 20km");
        habitControl.addHabit(habit1);
        habitControl.removeHabit(0);

        assertSame(habitControl.getHabit(0).getTitle(), "Run 20km");
    }
}
