package com.example.myapplication.viewmodel.activities;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.model.TermModel;
import com.example.myapplication.viewmodel.adapters.TermListAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TermListAdapter termListAdapter;
    // AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "studentDB").build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.cardView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        termListAdapter = new TermListAdapter(this, getMyList());
        mRecyclerView.setAdapter(termListAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    // TODO: Remove test values once database is built
    private ArrayList<TermModel> getMyList() {

        ArrayList<TermModel> terms = new ArrayList<>();

        TermModel m = new TermModel();
        m.setTermId(1);
        m.setTitle("First Semester");
        terms.add(m);

        m = new TermModel();
        m.setTermId(2);
        m.setTitle("Second Semester");
        terms.add(m);

        m = new TermModel();
        m.setTermId(3);
        m.setTitle("Third Semester");
        terms.add(m);

        return terms;
    }
}
