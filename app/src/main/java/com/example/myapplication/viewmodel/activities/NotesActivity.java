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
import com.example.myapplication.viewmodel.adapters.NotesListAdapter;
import java.util.List;

public class NotesActivity extends AppCompatActivity {

    private StudentViewModel studentViewModel;
    RecyclerView recyclerView;
    NotesListAdapter notesListAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.mainRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        notesListAdapter = new NotesListAdapter();
        recyclerView.setAdapter(notesListAdapter);

        studentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        studentViewModel.getAllCourses().observe(this, new Observer<List<Course>>() {
            @Override
            public void onChanged(@Nullable List<Course> courses) {
                notesListAdapter.setCourses(courses);
            }
        });
    }
}