package com.huynh.jess.jhuynh_habittracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.provider.Telephony.Mms.Part.FILENAME;

/**
 * Created by Jess on 2016-09-26.
 */

public class HabitListController {
    private static HabitList habitsList;

    public HabitListController()
    {
        habitsList = new HabitList();
    }

    public HabitList getHabitList()
    {
        return habitsList;
    }

    public void addHabit(Habit habit) {
        habitsList.addHabit(habit);
    }


    public void addMultipleHabits(HabitList loadedList) {
        for(Habit h : loadedList.getHabits())
        {
            habitsList.addHabit(h);
        }
    }

    public int size() {
        return this.habitsList.size();
    }

    public Habit getHabit(int index) {
        try {
            return habitsList.getHabit(index);
        } catch(IndexOutOfBoundsException exception){
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeHabit(Habit habit){
        habitsList.removeHabit(habit);
    }

    public void clearHabits() {
        habitsList.removeAll();
    }

}
