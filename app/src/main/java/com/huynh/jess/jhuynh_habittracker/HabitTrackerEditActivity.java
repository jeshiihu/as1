package com.huynh.jess.jhuynh_habittracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Jess on 2016-09-25.
 */

public class HabitTrackerEditActivity extends AppCompatActivity
{
    private final String DELETE_ACTION = "delete";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_single);
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
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(HabitTrackerEditActivity.this);
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
