package com.example.myapplication.viewmodel.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class EditTermActivity extends AppCompatActivity {

    private TextView currentTermTitle;
    private TextView startDate;
    private TextView endDate;
    private EditText updatedTermTitle;
    private Button updateStartDate;
    private Button updateTermButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editterm);
        getSupportActionBar().setTitle("Edit Term");

        currentTermTitle = findViewById(R.id.termtitle_text);
        startDate = findViewById(R.id.input_startdate);
        endDate = findViewById(R.id.input_enddate);
        updatedTermTitle = findViewById(R.id.input_termtitle);
        updateStartDate = findViewById(R.id.startdate_button);
        updateTermButton = findViewById(R.id.updateterm_button);
    }
}
