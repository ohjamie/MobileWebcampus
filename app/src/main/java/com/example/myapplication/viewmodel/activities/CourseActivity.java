package com.example.myapplication.C196PA;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

// TODO: transfer data from one screen to another
// video: part 2, 14:25

public class CourseActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    CourseListAdapter courseListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();

        mRecyclerView = findViewById(R.id.cardView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        courseListAdapter = new CourseListAdapter(this, getCourseList());
        mRecyclerView.setAdapter(courseListAdapter);

        Intent intent = getIntent();
        String mTitle = intent.getStringExtra("iTitle");
        actionBar.setTitle(mTitle);
    }

    // TODO: Remove test values once database is built
    private ArrayList<CourseModel> getCourseList() {

        ArrayList<CourseModel> courses = new ArrayList<>();

        CourseModel m = new CourseModel();
        m.setCourseId(1);
        m.setCourseTitle("Calculus");
        courses.add(m);

        m = new CourseModel();
        m.setCourseId(2);
        m.setCourseTitle("Organic Chemistry");
        courses.add(m);

        m = new CourseModel();
        m.setCourseId(3);
        m.setCourseTitle("Discrete Mathematics");
        courses.add(m);

        m = new CourseModel();
        m.setCourseId(4);
        m.setCourseTitle("Linear Algebra");
        courses.add(m);

        return courses;
    }
}
