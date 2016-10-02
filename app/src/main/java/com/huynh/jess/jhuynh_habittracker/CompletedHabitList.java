package com.huynh.jess.jhuynh_habittracker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Jess on 2016-10-01.
 */
public class CompletedHabitList implements Serializable
{
    private ArrayList<CompletedHabit> list;

    public CompletedHabitList()
    {
        list = new ArrayList<CompletedHabit>();
    }

    public Collection<CompletedHabit> getList()
    {
        return list;
    }

    public void addCompletedHabit(CompletedHabit habit)
    {
        list.add(habit);
    }

    public void removeCompletedHabit(CompletedHabit habit)
    {
        list.remove(habit);
    }

    public void removeCompletedHabit(int index) throws Exception
    {
        try
        {
            list.remove(index);
        }
        catch(IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getTotalCompletionCount()
    {
        return list.size();
    }

    public int getDailyCompletionsCount()
    {
        int counter = 0;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(new Date(System.currentTimeMillis()));

        for(CompletedHabit c : list)
        {
            if(c.getCompletionDate().equals(today))
                counter++;
        }

        return counter;
    }
}
