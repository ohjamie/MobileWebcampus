package com.example.myapplication.C196PA;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.c196pa.R;

public class TermListHolder extends RecyclerView.ViewHolder {

    public TextView mTermNumber;
    public TextView mTermTitle;

    public TermListController(@NonNull View itemView) {
        super(itemView);

        this.mTermNumber = itemView.findViewById(R.id.termNumber);
        this.mTermTitle = itemView.findViewById(R.id.termTitle);
    }
}

