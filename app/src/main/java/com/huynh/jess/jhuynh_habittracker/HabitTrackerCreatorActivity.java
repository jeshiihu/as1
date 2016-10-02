package com.huynh.jess.jhuynh_habittracker;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Jess on 2016-09-24.
 */

public class HabitTrackerCreatorActivity extends AppCompatActivity
{
    private HabitCreatorManager manager = new HabitCreatorManager();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_creator);

        // Get current date & auto fill the date edit text
        EditText editDate = (EditText)findViewById(R.id.editText_date);
        editDate.setText(manager.getCreatedDate());
    }

    // -------------- Buttton Click events --------------
    public void onBtnClickAddCreator(View view)
    {
        EditText editTitle = (EditText)findViewById(R.id.editText_habitTitle);
        manager.setTitle(editTitle.getText().toString());

        EditText editDate = (EditText)findViewById(R.id.editText_date);
        manager.setCreatedDateByStr(editDate.getText().toString());

        if(!manager.isValidTitle())
            Toast.makeText(this, "Please enter title", Toast.LENGTH_SHORT).show();
        else
        if(!manager.isValidDate())
            Toast.makeText(this, "Invalid date: yyyy-MM-dd", Toast.LENGTH_SHORT).show();
        else
        if(!manager.isValidRepeatSelection())
            Toast.makeText(this, "Please select at least one repeat day", Toast.LENGTH_SHORT).show();
        else
        {   // valid habit so add to the list!
            HabitTrackerManager.getHabitList().addHabit(manager.generateCreatedHabit());
            HabitTrackerManager.saveHabitList();
            setResult(RESULT_OK);
            finish();
        }
    }

    public void onBtnClickCancel(View view)
    { // return from activity
        setResult(RESULT_CANCELED);
        finish();
    }

    // ---------------- these toggle the selection on and off ----------------
    public void onCtnClickMon(View view)
    {
        Button btnMon = (Button)findViewById(R.id.btn_monday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Monday))
        {
            btnMon.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Monday);
        }
        else {
            btnMon.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Monday);
        }
    }

    public void onBtnClickTue(View view)
    {
        Button btnTue = (Button)findViewById(R.id.btn_tuesday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Tuesday))
        {
            btnTue.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Tuesday);
        }
        else {
            btnTue.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Tuesday);
        }
    }

    public void onBtnClickWed(View view)
    {
        Button btnWed = (Button)findViewById(R.id.btn_wednesday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Wednesday))
        {
            btnWed.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Wednesday);
        }
        else {
            btnWed.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Wednesday);
        }
    }

    public void onBtnClickThu(View view)
    {
        Button btnThu = (Button)findViewById(R.id.btn_thursday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Thursday))
        {
            btnThu.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Thursday);
        }
        else {
            btnThu.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Thursday);
        }
    }

    public void onBtnClickFri(View view)
    {
        Button btnFri = (Button)findViewById(R.id.btn_friday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Friday))
        {
            btnFri.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Friday);
        }
        else {
            btnFri.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Friday);
        }
    }

    public void onBtnClickSat(View view)
    {
        Button btnSat = (Button)findViewById(R.id.btn_saturday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Saturday))
        {
            btnSat.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Saturday);
        }
        else {
            btnSat.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Saturday);
        }
    }

    public void onBtnClickSun(View view)
    {
        Button btnSun = (Button)findViewById(R.id.btn_sunday);

        if(manager.getDaysSet().isDayContained(DaysSet.Day.Sunday))
        {
            btnSun.setBackgroundColor(ContextCompat.getColor(this, R.color.gray));
            manager.getDaysSet().removeDay(DaysSet.Day.Sunday);
        }
        else {
            btnSun.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
            manager.getDaysSet().addDay(DaysSet.Day.Sunday);
        }
    }
}
