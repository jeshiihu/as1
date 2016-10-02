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
        try
        {
            habitsList = loadFromFile();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return habitsList;
    }

    public HabitTrackerManager()
    {
        habitsList = new HabitList();
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
            // code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22, 2016
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
