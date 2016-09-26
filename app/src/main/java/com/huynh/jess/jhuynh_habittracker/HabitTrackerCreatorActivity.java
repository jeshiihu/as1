package com.huynh.jess.jhuynh_habittracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jess on 2016-09-24.
 */

public class HabitTrackerCreatorActivity extends AppCompatActivity
{
    private Habit newHabit;
    private String editStrDate;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_habit_tracker_creator);

        // Get current date
        final Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        editStrDate = format.format(date);

        // auto fill the date edit text
        EditText editDate = (EditText)findViewById(R.id.editText_date);
        editDate.setText(editStrDate);

        editDate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        Button addBtn = (Button)findViewById(R.id.btn_creatorOK);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EditText editTitle = (EditText)findViewById(R.id.editText_habitTitle);
                String sTitle = editTitle.getText().toString();
                if(sTitle.length() != 0)
                {
                    Habit newHabit = new Habit(sTitle, date.toString());

                    Intent returnIntent = new Intent();
                    returnIntent.putExtra("newHabit", newHabit);
                    setResult(RESULT_OK, returnIntent);
                    finish();
                }
            }
        });

        Button cancelBtn = (Button)findViewById(R.id.btn_creatorCancel);
        cancelBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setResult(RESULT_CANCELED);
                finish();
            }
        });

        final Button mondayBtn = (Button)findViewById(R.id.btn_monday);
        mondayBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
//                if(isDaySelected())
//                daySelected();
            }
        });
    }
}
