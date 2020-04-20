package com.example.myapplication.C196PA;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196pa.R;
import com.example.c196pa.Term;
import com.example.myapplication.TermListHolder;
import com.example.myapplication.TermModel;

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
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.termlist_view, null);

        return new TermListHolder(view); // return view to controller class
    }

    @Override
    public void onBindViewHolder(@NonNull TermListHolder holder, int position) {
        holder.mTermNumber.setText("" + terms.get(position).getTermId());
        holder.mTermTitle.setText(terms.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }
}
