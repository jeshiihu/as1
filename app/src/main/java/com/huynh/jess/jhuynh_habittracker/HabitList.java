package com.huynh.jess.jhuynh_habittracker;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Jess on 2016-09-28.
 */

public class HabitList {
    private ArrayList<Habit> list;

    public HabitList()
    {
        list = new ArrayList<Habit>();
    }

    public Collection<Habit> getHabits()
    {
        return list;
    }

    public void addHabit(Habit habit) {
        list.add(habit);
    }

    public int size() {
        return list.size();
    }

    public Habit getHabit(int index) {
        try {
            return list.get(index);
        } catch(IndexOutOfBoundsException exception){
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean contains(Habit habit) {
        return list.contains(habit);
    }

    public void removeHabit(Habit habit)
    {
        for(Habit h: list)
        {
            if(h.getTitle().equals(habit.getTitle()) && h.getCreatedDate().equals(habit.getCreatedDate()) &&
                    h.getDays().toString().equals(habit.getDays().toString()))
            {
                list.remove(h);
                break;
            }
        }
    }

    public CompletedHabitList getHabitCompletions() // only a copy of all of them
    {
        CompletedHabitList completedList = new CompletedHabitList();

        for(Habit h : list)
        {
            for(CompletedHabit ch : h.getCompletedHabits().getList())
                completedList.addCompletedHabit(ch);
        }
        completedList.sort();

        return completedList;
    }

    public HabitList getTodaysHabits()
    {
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        String currentDay = format.format(new Date(System.currentTimeMillis()));

        HabitList todayList = new HabitList();
        for(Habit h : list)
        {
            if(h.getDays().isDayContained(currentDay))
                todayList.addHabit(h);
        }

        return todayList;
    }

    public void removeCompletedHabit(CompletedHabit c)
    {
        for(Habit h: list)
        {
            if(h.getTitle().equals(c.getHabitTitle()))
            {
                for(CompletedHabit completed : h.getCompletedHabits().getList())
                {
                    if(completed.getCompletionDateTime().equals(c.getCompletionDateTime()))
                    {
                        h.getCompletedHabits().removeCompletedHabit(completed);
                        break;
                    }
                }
            }
        }
    }
}
