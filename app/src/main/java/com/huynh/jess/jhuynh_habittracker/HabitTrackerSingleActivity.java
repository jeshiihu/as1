package com.huynh.jess.jhuynh_habittracker;

import android.content.DialogInterface;
import android.content.Intent;
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
    private HabitSingleManager manager;
    private final String DELETE_ACTION = "delete";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_single);

        Habit habit = (Habit)getIntent().getExtras().getSerializable("habit");
        manager = new HabitSingleManager(habit);

        TextView title = (TextView)findViewById(R.id.singleView_habitTitle);
        title.setText(manager.getHabit().toString());

        TextView date = (TextView)findViewById(R.id.singleView_date);
        date.setText(manager.getHabit().getCreatedDate());

        TextView repeatedDays = (TextView)findViewById(R.id.singleView_repeatDays);
        repeatedDays.setText(manager.getHabit().getDays().toString());
    }

    private void leaveView(String buttonPressed)
    {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("actionType", buttonPressed);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    public void onBtnClickComplete(View view)
    {
        ImageButton completeBtn = (ImageButton)findViewById(R.id.btn_completeHabit);
        completeBtn.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.btn_complete_green));
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
                leaveView(DELETE_ACTION);
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
