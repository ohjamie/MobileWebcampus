package com.example.c196pa;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Hello World!!!!!");

        /**
        RecyclerView termListView;
        String[] allTerms;

        Resources res = getResources();
        termListView = (RecyclerView) findViewById(R.id.termList);
        allTerms = res.getStringArray(R.array.allTerms);

        termListView.setAdapter(new ArrayAdapter<String>(this, R.layout.termlist_view, allTerms));*/
    }
}
