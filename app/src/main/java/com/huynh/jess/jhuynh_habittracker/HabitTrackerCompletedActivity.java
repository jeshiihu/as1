package com.huynh.jess.jhuynh_habittracker;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Jess on 2016-10-01.
 */

public class HabitTrackerCompletedActivity extends AppCompatActivity
{
    CompletedHabit completedHabit;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_complete);

        int selected = (int)getIntent().getExtras().getSerializable("index");
        completedHabit = HabitTrackerManager.getHabitList().getHabitCompletions().getAt(selected);

        TextView title = (TextView)findViewById(R.id.completeView_habitTitle);
        title.setText(completedHabit.getHabitTitle());

        TextView date = (TextView)findViewById(R.id.completeView_date);
        date.setText(completedHabit.getCompletionDate());

        TextView repeatedDays = (TextView)findViewById(R.id.completeView_repeatDays);
        repeatedDays.setText(completedHabit.getRepeatedDays());
    }

    public void onBtnClickDelete(View view)
    {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HabitTrackerCompletedActivity.this);
        alertBuilder.setMessage("Are you sure you want to delete this completion?");
        alertBuilder.setCancelable(true);

        alertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int id)
            {
                dialog.cancel();
                HabitTrackerManager.getHabitList().removeCompletedHabit(completedHabit);
                HabitTrackerManager.saveHabitList();
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
