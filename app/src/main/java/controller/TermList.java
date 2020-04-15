package controller;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.c196pa.R;

public class TermList extends RecyclerView.ViewHolder {

    TextView mTermNumber;
    TextView mTermDescription;

    public TermList(@NonNull itemView) {
        super(itemView);

        this.mTermNumber = itemView.findViewById(R.id.termNumber);
        this.mTermDescription = itemView.findViewById(R.id.termDescription);
    }
}
