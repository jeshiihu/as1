package com.huynh.jess.jhuynh_habittracker;

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
        if(loadedList.getHabits() == null)
            return;

        for(Habit h : loadedList.getHabits())
        {
            habitsList.addHabit(h);
        }
    }

    public void removeHabit(Habit habit){
        habitsList.removeHabit(habit);
    }

    public void clearHabits() {
        habitsList.removeAll();
    }

}
