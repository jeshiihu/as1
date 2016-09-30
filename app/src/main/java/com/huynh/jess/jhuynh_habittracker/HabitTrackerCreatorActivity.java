package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class HabitTrackerCreatorActivity extends AppCompatActivity
{
    private Habit newHabit;
    private DaysSet days = new DaysSet();
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_creator);

        // Get current date & auto fill the date edit text
        EditText editDate = (EditText)findViewById(R.id.editText_date);
        days.setCurrentDateByDate(new Date(System.currentTimeMillis()));
        editDate.setText(days.getCurrentDateStr("yyyy-MM-dd"));
    }

    // -------------- Buttton Click events --------------
    public void onBtnClickAddCreator(View view) throws Exception
    {
        EditText editTitle = (EditText)findViewById(R.id.editText_habitTitle);

        if(editTitle.getText().toString().length() == 0)
        {
            Toast.makeText(this, "Please enter title", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText editDate = (EditText)findViewById(R.id.editText_date);

        try
        {
            days.setCurrentDateByStr(editDate.getText().toString());
        }
        catch (IllegalArgumentException e)
        {
            Toast.makeText(this, "Invalid date: yyyy-MM-dd", Toast.LENGTH_SHORT).show();
            return;
        }

        Habit newHabit = new Habit(editTitle.getText().toString());

        Intent returnIntent = new Intent();
        returnIntent.putExtra("newHabit", newHabit);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void onBtnClickCancel(View view)
    { // return from activity
        setResult(RESULT_CANCELED);
        finish();
    }


    public void onCtnClickMon(View view)
    {
        Button btnMon = (Button)findViewById(R.id.btn_monday);

        if(days.isDayContained(DaysSet.Day.Monday))
        {
            btnMon.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Monday);
        }
        else {
            btnMon.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Monday);
        }
    }

    public void onBtnClickTue(View view)
    {
        Button btnTue = (Button)findViewById(R.id.btn_tuesday);

        if(days.isDayContained(DaysSet.Day.Tuesday))
        {
            btnTue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Tuesday);
        }
        else {
            btnTue.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Tuesday);
        }
    }

    public void onBtnClickWed(View view)
    {
        Button btnWed = (Button)findViewById(R.id.btn_wednesday);

        if(days.isDayContained(DaysSet.Day.Wednesday))
        {
            btnWed.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Wednesday);
        }
        else {
            btnWed.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Wednesday);
        }
    }

    public void onBtnClickThu(View view)
    {
        Button btnThu = (Button)findViewById(R.id.btn_thursday);

        if(days.isDayContained(DaysSet.Day.Thursday))
        {
            btnThu.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Thursday);
        }
        else {
            btnThu.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Thursday);
        }
    }

    public void onBtnClickFri(View view)
    {
        Button btnFri = (Button)findViewById(R.id.btn_friday);

        if(days.isDayContained(DaysSet.Day.Friday))
        {
            btnFri.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Friday);
        }
        else {
            btnFri.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Friday);
        }
    }

    public void onBtnClickSat(View view)
    {
        Button btnSat = (Button)findViewById(R.id.btn_saturday);

        if(days.isDayContained(DaysSet.Day.Saturday))
        {
            btnSat.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Saturday);
        }
        else {
            btnSat.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Saturday);
        }
    }

    public void onBtnClickSun(View view)
    {
        Button btnSun = (Button)findViewById(R.id.btn_sunday);

        if(days.isDayContained(DaysSet.Day.Sunday))
        {
            btnSun.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            days.removeDay(DaysSet.Day.Sunday);
        }
        else {
            btnSun.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            days.addDay(DaysSet.Day.Sunday);
        }
    }
}
