package com.example.myapplication.C196PA;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    TermListAdapter termListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.cardView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        termListAdapter = new TermListAdapter(this, getMyList());
        mRecyclerView.setAdapter(termListAdapter);
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
