package com.example.myapplication.viewmodel.holders;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;


public class TermListHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView mTermNumber;
    public TextView mTermTitle;
    ItemClickListener itemClickListener;

    public TermListHolder(@NonNull View itemView) {
        super(itemView);

        this.mTermNumber = itemView.findViewById(R.id.termNumber);
        this.mTermTitle = itemView.findViewById(R.id.termTitle);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        this.itemClickListener.onItemClickListener(v, getLayoutPosition());
    }

    public void setItemClickListener(ItemClickListener ic) {
        this.itemClickListener = ic;
    }
}

