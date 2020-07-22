package com.example.myapplication.viewmodel.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class AssessmentsActivity extends AppCompatActivity {

    TextView preAssessmentStatus;
    TextView assessmentType;
    TextView assessmentStatus;
    Button takePreAssessmentButton;
    Button takeAssessmentButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assessments);

        preAssessmentStatus = findViewById(R.id.preassessment_status);
        assessmentType = findViewById(R.id.assessment_type);
        assessmentStatus = findViewById(R.id.assessment_status);
        takePreAssessmentButton = findViewById(R.id.preassessment_button);
        takeAssessmentButton = findViewById(R.id.assessment_button);
    }
}
