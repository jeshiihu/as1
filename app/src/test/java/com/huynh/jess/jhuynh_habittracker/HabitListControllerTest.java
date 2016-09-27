package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

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
    public void addHabit()
    {
        HabitListController habitControl = new HabitListController();
        Habit habit = habitFactory("Cook dinner");

        habitControl.addHabit(habit);

        assert(habitControl.size() == 1);
    }
}
