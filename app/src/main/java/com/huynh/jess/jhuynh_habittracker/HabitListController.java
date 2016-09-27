package com.huynh.jess.jhuynh_habittracker;

import java.util.ArrayList;

/**
 * Created by Jess on 2016-09-26.
 */

public class HabitListController {
    private ArrayList<Habit> habitsList;

    public HabitListController()
    {
        habitsList = new ArrayList<Habit>();
    }

    public void addHabit(Habit habit) {
        habitsList.add(habit);
    }

    public int size() {
        return this.habitsList.size();
    }
}
