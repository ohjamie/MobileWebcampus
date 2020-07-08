package com.example.myapplication.viewmodel.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.database.model.Term;
import com.example.myapplication.viewmodel.StudentViewModel;
import com.example.myapplication.viewmodel.adapters.TermListAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class TermActivity extends AppCompatActivity {

    public static final int ADD_TERM_REQUEST = 1;
    public static final int COURSE_LIST_REQUEST = 2;
    private StudentViewModel studentViewModel;
    RecyclerView mRecyclerView;
    TermListAdapter termListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Inflate and initialize term list
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.mainRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        termListAdapter = new TermListAdapter();
        mRecyclerView.setAdapter(termListAdapter);

        // Display local info from repository
        studentViewModel = new ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(StudentViewModel.class);
        studentViewModel.getAllTerms().observe(this, new Observer<List<Term>>() {
            @Override
            public void onChanged(@Nullable List<Term> terms) {
                termListAdapter.setTerms(terms);
            }
        });

        // Add term button
        FloatingActionButton addTermButton = findViewById(R.id.floatingBtn);
        addTermButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TermActivity.this, AddTermActivity.class);
                startActivityForResult(intent, ADD_TERM_REQUEST);
            }
        });

        // Click listener for Term to Course List
        termListAdapter.setOnItemClickListener(new TermListAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Term term) {
                Intent intent = new Intent(TermActivity.this, CourseActivity.class);
                startActivityForResult(intent, COURSE_LIST_REQUEST);
            }
        });

        // Swipe to delete
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                studentViewModel.deleteTerm(termListAdapter.getTermAt(viewHolder.getAdapterPosition()));
                Toast.makeText(TermActivity.this, "Term Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(mRecyclerView);
    }

    // Add term function
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_TERM_REQUEST && resultCode == RESULT_OK) {
            String termTitle = data.getStringExtra(AddTermActivity.EXTRA_TERM_TITLE);
            String startDate = data.getStringExtra(AddTermActivity.EXTRA_START_DATE);
            String endDate = data.getStringExtra(AddTermActivity.EXTRA_END_DATE);

            Term term = new Term();
            term.setTermTitle(termTitle);
            term.setStart(startDate);
            term.setEnd(endDate);
            studentViewModel.insertTerm(term);

            Toast.makeText(this, "Term saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Term saved", Toast.LENGTH_SHORT).show();
        }
    }
}
