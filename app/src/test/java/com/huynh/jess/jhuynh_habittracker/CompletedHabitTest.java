package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-30.
 */

public class CompletedHabitTest
{
    @Test
    public void setHabitConstructor()
    {
        Habit habit = new Habit("Clean room");
        CompletedHabit completedHabit = new CompletedHabit(habit);

        assertSame(completedHabit.getHabit(), habit);
    }

    @Test
    public void setHabitSetter()
    {
        Habit habit0 = new Habit("sleep in");
        Habit habit1 = new Habit("save up for headphones");
        CompletedHabit completedHabit = new CompletedHabit(habit0);

        assertSame(completedHabit.getHabit(), habit0);

        completedHabit.setHabit(habit1);
        assertSame(completedHabit.getHabit(), habit1);
    }

    @Test
    public void completeHabit()
    {
        Habit habit = new Habit();
        CompletedHabit completedHabit = new CompletedHabit(habit);

        completedHabit.complete();
        assert(completedHabit.isCompleted());
    }

    @Test
    public void completeHabitNotYet()
    {
        Habit habit = new Habit();
        CompletedHabit completedHabit = new CompletedHabit(habit);

        assertFalse(completedHabit.isCompleted());
    }
}
