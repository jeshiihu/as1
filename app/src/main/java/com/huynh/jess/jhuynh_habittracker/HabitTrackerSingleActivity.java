package com.huynh.jess.jhuynh_habittracker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Jess on 2016-09-25.
 */

public class HabitTrackerSingleActivity extends AppCompatActivity
{
    Habit habit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_single);

        int selected = (int)getIntent().getExtras().getSerializable("index");
        String str = (String)getIntent().getExtras().getSerializable("viewAllOrToday");
        if(!str.equals("All Habits"))
            habit = HabitTrackerManager.getHabitList(this).getTodaysHabits().getHabit(selected);
        else
            habit = HabitTrackerManager.getHabitList(this).getHabit(selected);

        TextView title = (TextView)findViewById(R.id.singleView_habitTitle);
        title.setText(habit.toString());

        TextView date = (TextView)findViewById(R.id.singleView_date);
        date.setText(habit.getCreatedDate());

        TextView repeatedDays = (TextView)findViewById(R.id.singleView_repeatDays);
        repeatedDays.setText(habit.getDays().toString());

        updateCounts();

        if(habit.isHabitCompletedToday())
        {
            ImageButton completeBtn = (ImageButton)findViewById(R.id.btn_completeHabit);
            completeBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.btn_complete_green));
        }
        else
        {
            ImageButton completeBtn = (ImageButton)findViewById(R.id.btn_completeHabit);
            completeBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.btn_complete));
        }
    }

    private void updateCounts()
    {
        TextView dailyCompletions = (TextView)findViewById(R.id.singleView_dailyCompletions);
        int daily = habit.getCompletedHabits().getDailyCompletionsCount();
        dailyCompletions.setText(Integer.toString(daily));

        TextView totalCompletions = (TextView)findViewById(R.id.singleView_totalCompletions);
        int total = habit.getCompletedHabits().getTotalCompletionCount();
        totalCompletions.setText(Integer.toString(total));
    }

    public void onBtnClickComplete(View view)
    {
        habit.completeHabit();

        ImageButton completeBtn = (ImageButton)findViewById(R.id.btn_completeHabit);
        completeBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.btn_complete_green));

        updateCounts();
    }

    public void onBtnClickDelete(View view)
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HabitTrackerSingleActivity.this);
        alertBuilder.setMessage("Are you sure you want to delete this habit?");
        alertBuilder.setCancelable(true);

        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
                HabitTrackerManager.getHabitList(HabitTrackerSingleActivity.this).removeHabit(habit);
                finish();
            }
        });

        alertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
            }
        });

        AlertDialog deleteAlert = alertBuilder.create();
        deleteAlert.show();
    }
}
