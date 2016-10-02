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

    public CompletedHabit getAt(int index)
    {
        return list.get(index);
    }

    public void sort()
    {
        ArrayList<CompletedHabit> sorted = new ArrayList<CompletedHabit>();

        for(CompletedHabit h : list)
        {
            int size = sorted.size();
            if(size == 0)
                sorted.add(h);
            else
            {
                if(sorted.get(size - 1).getDate().after(h.getDate()))
                {
                    CompletedHabit temp = sorted.get(size - 1);
                    sorted.remove(size - 1);
                    sorted.add(h);
                    sorted.add(temp);
                }
                else
                    sorted.add(h);
            }
        }

        list = sorted;
    }
}
