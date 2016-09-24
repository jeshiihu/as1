package com.huynh.jess.jhuynh_habittracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class HabitTrackerMainActivity extends AppCompatActivity {

    private ListView oldHabitList;
    private ArrayList<Habit> habitList = new ArrayList<Habit>();
    private ArrayAdapter<Habit> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_main);

        //Taken from lonely twitter lab
        ImageButton addButton = (ImageButton) findViewById(R.id.btn_addHabit);
        oldHabitList = (ListView) findViewById(R.id.oldHabitView);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK);

                Habit newHabit = new Habit("test");
                habitList.add(newHabit);
//                adapter.notifyDataSetChanged();
                // bring up habit editor view
            }
        });
    }

    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
//        loadFromFile();
        adapter = new ArrayAdapter<Habit>(this, R.layout.list_item, habitList);
        oldHabitList.setAdapter(adapter);
    }
}
