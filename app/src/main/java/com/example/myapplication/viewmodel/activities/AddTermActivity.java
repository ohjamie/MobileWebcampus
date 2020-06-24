package com.example.myapplication.viewmodel.activities;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Calendar;

public class AddTermActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    public static final String EXTRA_TERM_TITLE =
            "com.example.myapplication.viewmodel.activities.EXTRA_TERM_TITLE";
    public static final String EXTRA_START_DATE =
            "com.example.myapplication.viewmodel.activities.EXTRA_START_DATE";
    public static final String EXTRA_END_DATE =
            "com.example.myapplication.viewmodel.activities.EXTRA_END_DATE";

    private Button chooseStartDate;
    private Button addNewTerm;
    private EditText inputTermTitle;
    private TextView inputStartDate;
    private TextView inputEndDate;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addterm);
        getSupportActionBar().setTitle("Add Term");

        inputTermTitle = findViewById(R.id.input_termtitle);
        inputStartDate = findViewById(R.id.input_startdate);
        inputEndDate = findViewById(R.id.input_enddate);
        chooseStartDate = findViewById(R.id.startdate_button);
        addNewTerm  = findViewById(R.id.addterm_button);

        addNewTerm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTerm();
            }
        });
        chooseStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
    }

    private void addTerm() {
        String termTitle = inputTermTitle.getText().toString();
        String startDate = inputStartDate.getText().toString().substring(12);
        String endDate = inputEndDate.getText().toString().substring(10);

        Intent data = new Intent();
        data.putExtra(EXTRA_TERM_TITLE, termTitle);
        data.putExtra(EXTRA_START_DATE, startDate);
        data.putExtra(EXTRA_END_DATE, endDate);

        setResult(RESULT_OK, data);
        finish();
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        int endMonth = month+7;
        int endYear = year;
        if (month+1 > 6) {
            endMonth = endMonth-12;
            endYear = year + 1;
        }

        String startDate = "Start date: " + (month+1) + "/" + dayOfMonth + "/" + year;
        String endDate = "End date: " + endMonth + "/" + dayOfMonth + "/" + endYear;
        inputStartDate.setText(startDate);
        inputEndDate.setText(endDate);
    }
}
