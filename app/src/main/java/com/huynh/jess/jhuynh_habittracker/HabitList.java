package com.huynh.jess.jhuynh_habittracker;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jess on 2016-09-28.
 */

public class HabitList {
    private ArrayList<Habit> list;
    protected ArrayList<Listener> listeners;

    public HabitList()
    {
        list = new ArrayList<Habit>();
        listeners = new ArrayList<Listener>();
    }

    public HabitList(ArrayList<Habit> listHabit)
    {
        list = listHabit;
        listeners = new ArrayList<Listener>();
        notifyListeners();
    }

    public Collection<Habit> getHabits()
    {
        return list;
    }

    public void addHabit(Habit habit) {
        list.add(habit);
        notifyListeners();
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
        notifyListeners();
    }

    public void removeHabit(int selectedIndex) {
        try
        {
            list.remove(selectedIndex);
            notifyListeners();
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

    private ArrayList<Listener> getListeners() {
        if (listeners == null ) {
            listeners = new ArrayList<Listener>();
        }
        return listeners;
    }

    public void notifyListeners()
    {
        for(Listener l : getListeners())
        {
            l.update();
        }
    }

    public void addListener(Listener l)
    {
        listeners.add(l);
        int i = 0;
    }

    public void removeListener(Listener l)
    {
        listeners.remove(l);
    }

}
