

package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class HabitTrackerMainActivity extends AppCompatActivity {

    public final static int REQ_CODE_CREATOR = 1;
    public final static int REQ_CODE_EDITOR = 2;

    private static final String FILENAME = "file.sav";
    private HabitListController habitCtrl = new HabitListController();

//    private ListView oldHabitList;
//    private ArrayList<Habit> habitList = new ArrayList<Habit>();
//    private ArrayAdapter<Habit> adapter;


    private int   selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_main);

        ListView listview = (ListView)findViewById(R.id.habitListView);
        final ArrayList<Habit> list;
        if(habitCtrl.getHabitList() != null)
        {
            Collection<Habit> habits = habitCtrl.getHabitList().getHabits();
            list = new ArrayList<Habit>(habits);
        }
        else{
            habitCtrl.clearHabits();
            list = new ArrayList<Habit>();
        }

        final ArrayAdapter<Habit> habitAdapter = new ArrayAdapter<Habit>(this, R.layout.list_item, list);
        listview.setAdapter(habitAdapter);

        habitCtrl.getHabitList().addListener(new Listener() {
            @Override
            public void update() {
                list.clear();
                Collection<Habit> students = habitCtrl.getHabitList().getHabits();
                list.addAll(students);
                habitAdapter.notifyDataSetChanged();
                saveInFile();
            }
        });

        TextView textCurrentDay = (TextView)findViewById(R.id.textView_mainTitle);
        Date dayOfWeek = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        textCurrentDay.setText(format.format(dayOfWeek));

        ImageButton addButton = (ImageButton)findViewById(R.id.btn_addHabit);
        listview = (ListView)findViewById(R.id.habitListView);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedIndex = i;
                Intent editIntent = new Intent(HabitTrackerMainActivity.this , HabitTrackerSingleActivity.class);
                editIntent.putExtra("habit", habitCtrl.getHabitList().getHabit(i));
                startActivityForResult(editIntent, REQ_CODE_EDITOR);
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinnerView);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.spinner_views, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        loadFromFile();
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
            HabitList loadedList = new HabitList((ArrayList<Habit>) gson.fromJson(in, listType));
            habitCtrl.clearHabits();
            habitCtrl.addMultipleHabits(loadedList);
        }
        catch (FileNotFoundException e)
        {
            habitCtrl.clearHabits();
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
            gson.toJson(habitCtrl.getHabitList().getHabits(), writer);

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
                habitCtrl.addHabit(newHabit);
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
                    habitCtrl.getHabitList().removeHabit(selectedIndex);
                }
            }
        }
    }

    // -------------- Buttton Click events --------------
    public void onBtnClickAdd(View view) {
        setResult(RESULT_OK);

        //start new activity to create the habit
        Intent intentCreator = new Intent(HabitTrackerMainActivity.this , HabitTrackerCreatorActivity.class);
        startActivityForResult(intentCreator, REQ_CODE_CREATOR);
    }
}
