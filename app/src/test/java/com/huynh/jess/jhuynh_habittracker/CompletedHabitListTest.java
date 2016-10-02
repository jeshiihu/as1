package com.huynh.jess.jhuynh_habittracker;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Jess on 2016-10-02.
 */

public class CompletedHabitListTest
{
    private CompletedHabit initCompletedHabit()
    {
        Habit habit = new Habit("Bake cookies");
        habit.setCreatedDateByStr("2013-11-02");

        DaysSet days = new DaysSet();
        days.addDay(DaysSet.Day.Monday);
        habit.setDays(days);


        return new CompletedHabit(habit);
    }

    @Test
    public void addCompletion()
    {
        CompletedHabitList list = new CompletedHabitList();
        CompletedHabit h = initCompletedHabit();
        list.addCompletedHabit(h);

        assert(list.getList().size() == 1);
        assertSame(list.getAt(0), h);
    }

    @Test
    public void delelteCompletion()
    {
        CompletedHabitList list = new CompletedHabitList();
        CompletedHabit h = initCompletedHabit();
        list.addCompletedHabit(h);
        list.removeCompletedHabit(h);

        assert(list.getList().size() == 0);
    }

    @Test
    public void getTotalCompletion()
    {
        CompletedHabitList list = new CompletedHabitList();
        list.addCompletedHabit(initCompletedHabit());
        list.addCompletedHabit(initCompletedHabit());
        list.addCompletedHabit(initCompletedHabit());

        assert(list.getTotalCompletionCount() == 3);
        assert(list.getDailyCompletionsCount() == 3);
    }
}
