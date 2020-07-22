package com.example.myapplication.viewmodel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.database.model.Term;
import java.util.ArrayList;
import java.util.List;

public class TermListAdapter extends RecyclerView.Adapter<TermListAdapter.TermListHolder> {

    private List<Term> terms = new ArrayList<>();
    private OnItemClickListener listener;

    class TermListHolder extends RecyclerView.ViewHolder {

        public TextView mTermNumber;
        public TextView mTermTitle;
        public TextView mDates;

        public TermListHolder(@NonNull View itemView) {
            super(itemView);

            this.mTermNumber = itemView.findViewById(R.id.term_num);
            this.mTermTitle = itemView.findViewById(R.id.term_title);
            this.mDates = itemView.findViewById(R.id.term_duration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(terms.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Term term);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TermListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_terms, parent, false);
        return new TermListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TermListHolder holder, int position) {
        Term currentTerm = terms.get(position);
        holder.mTermNumber.setText("Term " + currentTerm.getTermId());
        holder.mTermTitle.setText(currentTerm.getTermTitle());
        holder.mDates.setText(currentTerm.getStart() + " to " + currentTerm.getEnd());
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }

    public void setTerms(List<Term> terms) {
        this.terms = terms;
        notifyDataSetChanged();
    }

    public Term getTermAt(int position) {
        return terms.get(position);
    }
}

