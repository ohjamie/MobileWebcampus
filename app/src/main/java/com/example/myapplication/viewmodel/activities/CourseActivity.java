package com.example.myapplication.viewmodel.activities;

import android.os.Bundle;
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
import java.util.List;

public class CourseActivity extends AppCompatActivity {

    private StudentViewModel studentViewModel;

    RecyclerView mRecyclerView;
    CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Courses");

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

    }
}
