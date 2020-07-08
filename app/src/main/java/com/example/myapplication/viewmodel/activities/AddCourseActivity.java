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
import com.example.myapplication.viewmodel.adapters.CourseChecklistAdapter;

import java.util.List;

public class AddCourseActivity extends AppCompatActivity {

    private StudentViewModel studentViewModel;
    RecyclerView recyclerView;
    CourseChecklistAdapter courseChecklistAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcourse);
        getSupportActionBar().setTitle("Add Courses");

        // Display course list in recyclerview
        recyclerView = findViewById(R.id.courses_recyclerview);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        courseChecklistAdapter = new CourseChecklistAdapter();
        recyclerView.setAdapter(courseChecklistAdapter);

        studentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        studentViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> courses) {
                courseChecklistAdapter.setCourses(courses);
            }
        });

    }


}
