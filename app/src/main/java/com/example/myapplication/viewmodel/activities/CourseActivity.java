package com.example.myapplication.viewmodel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.model.Course;
import com.example.myapplication.viewmodel.StudentViewModel;
import com.example.myapplication.viewmodel.adapters.CourseListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class CourseActivity extends AppCompatActivity {

    public static final String EXTRA_COURSE_NAME =
            "com.example.myapplication.viewmodel.activities.EXTRA_COURSE_NAME";

    public static final int ADD_COURSE_REQUEST = 1;
    public static final int COURSE_DETAILS_REQUEST = 2;
    private StudentViewModel studentViewModel;
    MenuItem editTermButton;
    RecyclerView mRecyclerView;
    CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        getSupportActionBar().setTitle(intent.getStringExtra(TermActivity.EXTRA_TERM_TITLE));

        mRecyclerView = findViewById(R.id.mainRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseListAdapter = new CourseListAdapter();
        mRecyclerView.setAdapter(courseListAdapter);

        studentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        studentViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> courses) {
                courseListAdapter.setCourses(courses);
            }
        });

        // Add course button
        FloatingActionButton addCourseButton = findViewById(R.id.floatingBtn);
        addCourseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, AddCourseActivity.class);
                startActivityForResult(intent, ADD_COURSE_REQUEST);
            }
        });

        courseListAdapter.setOnItemClickListener(new CourseListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Course course) {
                String courseName = course.getCourseName();
                Intent intent = new Intent(CourseActivity.this, CourseDetailsActivity.class);
                intent.putExtra(EXTRA_COURSE_NAME, courseName);

                startActivityForResult(intent, COURSE_DETAILS_REQUEST);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_courses, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.edit_term) {
            editTerm();
        }
<<<<<<< HEAD
        return true;
    }

    public void editTerm() {
        Intent intent = new Intent(CourseActivity.this, EditTermActivity.class);

        startActivityForResult(intent, 1);
=======
    }

    public void editTerm() {
        // TODO
>>>>>>> 5855c94a6917dba07d19c8841d561122e8d03055
    }
}
