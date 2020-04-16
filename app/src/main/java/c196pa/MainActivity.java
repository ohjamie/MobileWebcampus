package com.example.c196pa;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import adapters.TermListAdapter;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TermListAdapter termListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Hello World!!!!!");

        mRecyclerView = findViewById(R.id.termListVieww);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        termListAdapter = new TermListAdapter(this, getMyList());
    }

    private ArrayList<com.example.c196pa.Term> getMyList() {

        ArrayList<com.example.c196pa.Term> terms = new ArrayList<>();

        com.example.c196pa.Term m = new com.example.c196pa.Term();
        m.setTermId("1");
        m.setTitle("First Semester");
        // m.setStartDate(LocalDateTime.now());
        // m.setEndDate(LocalDateTime.now().plusMonths(6));
        // m.setCurrent(1);
        terms.add(m);

        m = new com.example.c196pa.Term();
        m.setTermId("2");
        m.setTitle("Second Semester");
        // m.setStartDate(LocalDateTime.now());
        // m.setEndDate(LocalDateTime.now().plusMonths(6));
        // m.setCurrent(1);
        terms.add(m);

        m = new com.example.c196pa.Term();
        m.setTermId("3");
        m.setTitle("Third Semester");
        // m.setStartDate(LocalDateTime.now());
        // m.setEndDate(LocalDateTime.now().plusMonths(6));
        // m.setCurrent(1);
        terms.add(m);

        return terms;
    }
}
