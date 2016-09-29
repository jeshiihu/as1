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
}
