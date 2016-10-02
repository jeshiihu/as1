package com.huynh.jess.jhuynh_habittracker;

/**
 * Created by Jess on 2016-09-30.
 */
public class HabitSingleManager
{
    private Habit passedInHabit;

    public HabitSingleManager(Habit habit)
    {
        passedInHabit = habit;
    }

    public Habit getHabit()
    {
        return passedInHabit;
    }

    public Boolean isHabitCompletedToday()
    {
        if(passedInHabit.getCompletedHabits().getDailyCompletionsCount() > 0)
            return Boolean.TRUE;

        return Boolean.FALSE;
    }

    public void completeHabit()
    {
        CompletedHabit newCompletion = new CompletedHabit(passedInHabit.getTitle(), passedInHabit.getCreatedDate());
        passedInHabit.getCompletedHabits().addCompletedHabit(newCompletion);
    }
}
