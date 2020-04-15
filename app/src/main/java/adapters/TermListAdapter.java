package adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.c196pa.Term;
import java.util.ArrayList;
import controller.TermList;

public class TermListAdapter extends RecyclerView.Adapter<TermList> {

    Context c;
    ArrayList<Term> terms;

    @NonNull
    @Override
    public TermList onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TermList holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
