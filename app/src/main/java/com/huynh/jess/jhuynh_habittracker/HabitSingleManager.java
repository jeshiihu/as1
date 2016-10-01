package com.huynh.jess.jhuynh_habittracker;

/**
 * Created by Jess on 2016-09-30.
 */
public class HabitSingleManager
{
    private Habit passedInHabit;
    private CompletedHabit completedHabit;
    private Boolean habitCompleted = Boolean.FALSE;

    public HabitSingleManager(Habit habit)
    {
        passedInHabit = habit;
    }

    public CompletedHabit getCompletedHabit() throws Exception
    {
        if(!habitCompleted)
            throw new RuntimeException();

        return completedHabit;
    }

    public Habit getHabit()
    {
        return passedInHabit;
    }

    public Boolean isHabitCompleted()
    {
        return habitCompleted;
    }

    public void completeHabit()
    {
        if(!habitCompleted)
        {
            completedHabit = new CompletedHabit(passedInHabit);
            completedHabit.complete();
        }
        else
        {
            
        }
    }
}
