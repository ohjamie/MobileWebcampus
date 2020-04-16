package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196pa.R;
import com.example.c196pa.Term;

import java.util.ArrayList;

import controller.TermList;

public class TermListAdapter extends RecyclerView.Adapter<TermList> {

    Context c;
    ArrayList<Term> terms;

    public TermListAdapter(Context c, ArrayList<Term> terms) {
        this.c = c;
        this.terms = terms;
    }

    @NonNull
    @Override
    public TermList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.termlist_view, null);

        return new TermList(view); // return view to controller class
    }

    @Override
    public void onBindViewHolder(@NonNull TermList holder, int position) {
        holder.mTermNumber.setText(terms.get(position).getTermId());
        holder.mTermTitle.setText(terms.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return terms.size();
    }
}
