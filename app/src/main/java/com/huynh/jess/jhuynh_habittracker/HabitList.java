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

    public HabitList(ArrayList<Habit> listHabit)
    {
        list = listHabit;
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

    public void removeHabit(Habit habit){
        list.remove(habit);
    }

    public void removeHabit(int selectedIndex) {
        try
        {
            list.remove(selectedIndex);
        }
        catch (IndexOutOfBoundsException e)
        {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeAll()
    {
        list.clear();
    }

    public CompletedHabitList getHabitCompletions()
    {
        CompletedHabitList completedList = new CompletedHabitList();

        for(Habit h : list)
        {
            for(CompletedHabit ch : h.getCompletedHabits().getList())
                completedList.addCompletedHabit(ch);
        }

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
}
