
/*
https://github.com/abramhindle/student-picker/blob/master/src/ca/softwareprocess/studentpicker/StudentListController.java
Format and how write some code has been taken from

Copyright (C) 2014 Abram Hindle abram.hindle@softwareprocess.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.
This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.
You should have received a copy of the GNU General Public License
along with this program. If not, see <http://www.gnu.org/licenses/>.
*/


package com.huynh.jess.jhuynh_habittracker;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;

/**
 * Created by Jess on 2016-09-26.
 */

public class HabitTrackerManager {
    private static final String FILENAME = "habit_tracker.sav";
    private static HabitList habitsList = new HabitList();
    private static Context context;

    static public HabitList getHabitList()
    {
        habitsList = loadFromFile();

        if(habitsList == null)
            return new HabitList();

        return habitsList;
    }

    public HabitTrackerManager()
    {
        habitsList = new HabitList();
    }

    static public void addHabit(Habit habit)
    {
        if(habitsList == null)
        {
            habitsList = new HabitList();
        }

        habitsList.addHabit(habit);
    }

    static public void setContext(Context c)
    {
        context = c;
    }

    static public void saveHabitList()
    {
        try
        {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter writer = new OutputStreamWriter(fos);

            Gson gson = new Gson();
            gson.toJson(habitsList, writer);

            writer.flush();
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException();
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
    }

    static public HabitList loadFromFile()
    {
        try
        {
            FileInputStream fis = context.openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            Type listType = new TypeToken<HabitList>(){}.getType();
            return gson.fromJson(in, listType);
        }
        catch (FileNotFoundException e)
        {
            return new HabitList();
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
    }

}
