package com.example.myapplication.viewmodel.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.R;
import com.example.myapplication.database.model.Course;
import java.util.ArrayList;
import java.util.List;

public class NotesListAdapter extends RecyclerView.Adapter<NotesListAdapter.NotesListHolder> {

    private List<Course> courses = new ArrayList<>();

    class NotesListHolder extends RecyclerView.ViewHolder{
        TextView noteTitle;
        TextView description;

        public NotesListHolder (@NonNull View itemView) {
            super(itemView);

            this.noteTitle = itemView.findViewById(R.id.note_title);
            this.description = itemView.findViewById(R.id.note_description);
        }
    }

    @NonNull
    @Override
    public NotesListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_notes, parent, false);
        return new NotesListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesListHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.noteTitle.setText(currentCourse.getNoteTitle());
        holder.description.setText(currentCourse.getNoteDescription());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
        notifyDataSetChanged();
    }
}