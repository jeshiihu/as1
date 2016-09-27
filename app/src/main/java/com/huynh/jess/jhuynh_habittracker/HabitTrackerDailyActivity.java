
// Code taken and referenced from: Alex Makepeace
// CMPUT 301 Lab 3 Thursday 22, 2016
// https://github.com/sensible-heart/lonelyTwitter/blob/master/app/src/main/java/ca/ualberta/cs/lonelytwitter/LonelyTwitterActivity.java

package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

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
import java.util.ArrayList;
import java.util.Date;


public class HabitTrackerDailyActivity extends AppCompatActivity {

    public final static int REQ_CODE_CREATOR = 1;
    public final static int REQ_CODE_EDITOR = 2;

    private static final String FILENAME = "file.sav";
    private ListView oldHabitList;
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private ArrayAdapter<Habit> adapter;

    private int   selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_daily);

        ImageButton addButton = (ImageButton)findViewById(R.id.btn_addHabit);
        oldHabitList = (ListView)findViewById(R.id.oldHabitView);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_OK);

                //start new activity to create the habit
                Date currDate = new Date(System.currentTimeMillis());
                Habit newHabit = new Habit("", currDate.toString());

                Intent intentCreator = new Intent(HabitTrackerDailyActivity.this , HabitTrackerCreatorActivity.class);
                startActivityForResult(intentCreator, REQ_CODE_CREATOR);
            }
        });

        oldHabitList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
                Intent editIntent = new Intent(HabitTrackerDailyActivity.this , HabitTrackerEditActivity.class);
                startActivityForResult(editIntent, REQ_CODE_EDITOR);
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        loadFromFile();
        adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, habitList);
        oldHabitList.setAdapter(adapter);
    }

    private void loadFromFile()
    {
        try
        {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();
            // code taken from http://stackoverflow.com/questions/12384064/gson-convert-from-json-to-a-typed-arraylistt Sept.22, 2016
            Type listType = new TypeToken<ArrayList<Habit>>(){}.getType();
            habitList = gson.fromJson(in, listType);

        }
        catch (FileNotFoundException e)
        {
            habitList = new ArrayList<Habit>();
        }
        catch (IOException e)
        {
            throw new RuntimeException();
        }
    }

    private void saveInFile() {
        try
        {
            FileOutputStream fos = openFileOutput(FILENAME, 0); // 0 is overriding rather than appending
            OutputStreamWriter writer = new OutputStreamWriter(fos);

            Gson gson = new Gson();
            gson.toJson(habitList, writer);

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == REQ_CODE_CREATOR)
        {
            if(resultCode == RESULT_OK)
            {
                Habit newHabit = (Habit) data.getExtras().getSerializable("newHabit");
                habitList.add(newHabit);
                adapter.notifyDataSetChanged();
                saveInFile();
            }
            else if(resultCode == RESULT_CANCELED)
            {
                // do nothing
            }
        }

        if(requestCode == REQ_CODE_EDITOR)
        {
            if(resultCode == RESULT_OK)
            {
                String action = data.getExtras().getString("actionType");
                if(action.equals("delete"))
                {
                    habitList.remove(selectedIndex);
                    adapter.notifyDataSetChanged();
                    saveInFile();
                }
            }
        }
    }
}
