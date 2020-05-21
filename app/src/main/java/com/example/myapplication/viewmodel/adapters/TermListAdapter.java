package com.example.myapplication.viewmodel.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.database.model.TermModel;
import com.example.myapplication.viewmodel.activities.CourseActivity;
import com.example.myapplication.viewmodel.holders.ItemClickListener;
import com.example.myapplication.viewmodel.holders.TermListHolder;

import java.util.ArrayList;

public class TermListAdapter extends RecyclerView.Adapter<TermListHolder> {

    Context c;
    ArrayList<TermModel> terms;

    public TermListAdapter(Context c, ArrayList<TermModel> terms) {
        this.c = c;
        this.terms = terms;
    }

    @NonNull
    @Override
    public TermListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_terms, null);

        return new TermListHolder(view); // return view to controller class
    }

    @Override
    public void onBindViewHolder(@NonNull final TermListHolder holder, int position) {
        holder.mTermNumber.setText("" + terms.get(position).getTermId());
        holder.mTermTitle.setText(terms.get(position).getTitle());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = terms.get(position).getTitle();

                Intent intent = new Intent(c, CourseActivity.class);
                intent.putExtra("iTitle", gTitle);
                c.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return terms.size();
    }
}
