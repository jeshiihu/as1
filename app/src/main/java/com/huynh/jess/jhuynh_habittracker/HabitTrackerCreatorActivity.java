package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class HabitTrackerCreatorActivity extends AppCompatActivity
{
    private Habit newHabit;
    private DaysSet days = new DaysSet();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_creator);

        // Get current date & auto fill the date edit text
        EditText editDate = (EditText)findViewById(R.id.editText_date);
        days.setCurrentDate(new Date(System.currentTimeMillis()));
        editDate.setText(days.getCurrentDateStr("yyyy-MM-dd"));
    }

    // -------------- Buttton Click events --------------
    public void onBtnClickAddCreator(View view) {
        EditText editTitle = (EditText)findViewById(R.id.editText_habitTitle);
        String sTitle = editTitle.getText().toString();

        if(sTitle.length() != 0)
        {
            Date date = new Date(System.currentTimeMillis());
            Habit newHabit = new Habit(sTitle, date.toString());

            Intent returnIntent = new Intent();
            returnIntent.putExtra("newHabit", newHabit);
            setResult(RESULT_OK, returnIntent);
            finish();
        }
    }

    public void onBtnClickCancel(View view) { // return from activity
        setResult(RESULT_CANCELED);
        finish();
    }

    public void onBtnClickSun(View view) {
       // change colour
    }

    public void onBtnClickMon(View view) {
        //change colour
    }

    public void onBtnClickTue(View view) {
        // change colour
    }

    public void onBtnClickWed(View view) {
        //change colour
    }

    public void onBtnClickThu(View view) {
        // change colour
    }

    public void onBtnClickFri(View view) {
        //change colour
    }

    public void onBtnClickSat(View view) {
        // change colour
    }
}
