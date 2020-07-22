package com.example.myapplication.viewmodel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class CourseDetailsActivity extends AppCompatActivity {

    TextView courseStatus;
    TextView courseDuration;
    TextView mentorName;
    TextView mentorEmail;
    TextView mentorNum;
    TextView assessmentStatus;
    Button assessmentsButton;
    Button notesButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursedetails);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra(CourseActivity.EXTRA_COURSE_NAME));

        courseStatus = findViewById(R.id.course_status);
        courseDuration = findViewById(R.id.course_duration);
        mentorName = findViewById(R.id.mentor_name);
        mentorEmail = findViewById(R.id.mentor_email);
        mentorNum = findViewById(R.id.mentor_number);
        assessmentStatus = findViewById(R.id.assessment_status);
        assessmentsButton = findViewById(R.id.assessments_button);
        notesButton = findViewById(R.id.notes_button);

        assessmentsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailsActivity.this, AssessmentsActivity.class);
                startActivityForResult(intent, 1);
            }
        });

        notesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailsActivity.this, NotesActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }
}
