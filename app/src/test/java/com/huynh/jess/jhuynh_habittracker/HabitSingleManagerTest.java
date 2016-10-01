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
    public void getContainedHabit()
    {
        Habit habit = new Habit();
        HabitSingleManager manager = new HabitSingleManager(habit);

        assertSame(manager.getHabit(), habit);
    }
}
