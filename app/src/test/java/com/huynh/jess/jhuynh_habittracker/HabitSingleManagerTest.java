package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-30.
 */

//@Test
//public void ()
//{
//
//}

public class HabitSingleManagerTest
{
    @Test
    public void setAndGetCompletedHabit()
    {
        HabitSingleManager manager = new HabitSingleManager();
        CompletedHabit completed = new CompletedHabit(new Habit());
        manager.setCompletedHabit(completed);

        assertSame(manager.getCompletedHabit(), completed);
    }

    @Test
    public void getDailyCompletions()
    {
        HabitSingleManager manager = new HabitSingleManager();
        CompletedHabit completed = new CompletedHabit(new Habit());
        completed.complete();
    }
}
