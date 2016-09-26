package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

/**
 * Created by Jess on 2016-09-25.
 */

public class HabitTrackerEditActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_editor);

        ImageButton deleteBtn = (ImageButton)findViewById(R.id.btn_deleteHabit);
        deleteBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("actionType", "delete");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });
    }
}
