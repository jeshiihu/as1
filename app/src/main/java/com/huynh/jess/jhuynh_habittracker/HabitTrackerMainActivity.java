

package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class HabitTrackerMainActivity extends AppCompatActivity
{
    private ListView listView;
    private TextView title;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_main);
        HabitTrackerManager.setContext(this);

        listView = (ListView)findViewById(R.id.habitListView);

        title = (TextView)findViewById(R.id.textView_mainTitle);
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        title.setText(format.format(new Date(System.currentTimeMillis())));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                Intent intent;
                if(title.getText().equals("History")) // need to open the completed activity
                    intent = new Intent(HabitTrackerMainActivity.this, HabitTrackerCompletedActivity.class);
                else
                {   // need to open the single activity
                    intent = new Intent(HabitTrackerMainActivity.this, HabitTrackerSingleActivity.class);
                    intent.putExtra("viewAllOrToday", title.getText());
                }

                intent.putExtra("index", i);
                startActivity(intent);
            }
        });

        spinner = (Spinner) findViewById(R.id.spinnerView);
        ArrayAdapter<CharSequence> adapterSpinner = ArrayAdapter.createFromResource(this, R.array.spinner_views, android.R.layout.simple_spinner_item);
        adapterSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapterSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = parent.getSelectedItem().toString();
                updateView(item);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        spinner.setSelection(0);
        updateView("");
    }

    // update the view based on what a user has selected with the spinner
    protected void updateView(String view)
    {
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        String today = format.format(new Date(System.currentTimeMillis()));

        if(view.equals("All Habits"))
        {
            title.setText(view);

            Collection<Habit> list = HabitTrackerManager.getHabitList().getHabits();
            ArrayAdapter<Habit> adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, new ArrayList<Habit>(list));
            listView.setAdapter(adapter);
        }
        else
        if(view.equals("History"))
        {
            title.setText(view);

            Collection<CompletedHabit> list = HabitTrackerManager.getHabitList().getHabitCompletions().getList();
            ArrayAdapter<CompletedHabit> completedAdapter = new ArrayAdapter<CompletedHabit>(this, R.layout.list_item, new ArrayList<CompletedHabit>(list));
            listView.setAdapter(completedAdapter);
        }
        else
        {
            title.setText(today);

            Collection<Habit> list = HabitTrackerManager.getHabitList().getTodaysHabits().getHabits();
            ArrayAdapter<Habit>adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, new ArrayList<Habit>(list));
            listView.setAdapter(adapter);
        }
    }

    // -------------- Buttton Click events --------------
    public void onBtnClickAdd(View view) {
        setResult(RESULT_OK);

        //start new activity to create the habit
        Intent intentCreator = new Intent(HabitTrackerMainActivity.this , HabitTrackerCreatorActivity.class);
        startActivity(intentCreator);
    }
}
