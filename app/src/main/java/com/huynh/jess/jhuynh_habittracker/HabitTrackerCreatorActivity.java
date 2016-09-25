package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class HabitTrackerCreatorActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_creator);

        Intent intent = getIntent();
        ViewGroup layout = (ViewGroup)findViewById(R.id.activity_habit_tracker_creator);

        TextView dateText = (TextView)findViewById(R.id.textView_editorDate);
        Date date = new Date(System.currentTimeMillis());
        dateText.setText(date.toString());
    }
}
