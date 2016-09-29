package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-09-28.
 */

public class HabitListTest {

    @Test
    public void addHabit()
    {
        HabitList list = new HabitList();
        Habit habit = new Habit();
        list.addHabit(habit);

        assertTrue("Habit List Size is incorrect", list.size() == 1);
        assertTrue("Habit Not Contained", list.contains(habit));
    }

    @Test
    public void addMultipleHabits()
    {
        HabitList list = new HabitList();
        Habit habit = new Habit();

        Habit habit2 = new Habit();
        list.addHabit(habit);
        list.addHabit(habit2);

        assertTrue("Habit List Size is incorrect", list.size() == 2);
        assertTrue("Habit Not Contained", list.contains(habit));
        assertTrue("Habit2 Not Contained", list.contains(habit2));
    }

    @Test
    public void removeHabit()
    {
        HabitList list = new HabitList();
        Habit habit = new Habit();
        list.addHabit(habit);
        list.removeHabit(habit);

        assertTrue("Habit List Size is incorrect", list.size() == 0);
        assertFalse("Habit is still contained", list.contains(habit));
    }

    Boolean updated = Boolean.FALSE;
    @Test
    public void notifyListeners() {
        HabitList habitList = new HabitList();
        updated = Boolean.FALSE;
        Listener l = new Listener() {
            public void update() {
                HabitListTest.this.updated = true;
            }
        };

        habitList.addListener(l);
        Habit habit = new Habit();
        habitList.addHabit(habit);
        assertTrue("No update on add", this.updated);

        updated = false;
        habitList.removeHabit(habit);
        assertTrue("no update from remove", this.updated);
    }

    @Test
    public void testRemoveListeners() {
        HabitList habitList = new HabitList();
        updated = Boolean.FALSE;
        Listener l = new Listener() {
            public void update() {
                HabitListTest.this.updated = true;
            }
        };

        habitList.addListener(l);
        habitList.removeListener(l);
        habitList.addHabit(new Habit());
        assertFalse("updated listener when it was removed", this.updated);
    }
}
