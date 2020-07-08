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

public class CourseChecklistAdapter extends RecyclerView.Adapter<CourseChecklistAdapter.CourseChecklistHolder> {

    private List<Course> courses = new ArrayList<>();

    class CourseChecklistHolder extends RecyclerView.ViewHolder {

        public TextView mCourseName;

        public CourseChecklistHolder(@NonNull View itemView) {
            super(itemView);

            this.mCourseName = itemView.findViewById(R.id.course_name);
        }
    }

    @NonNull
    @Override
    public CourseChecklistAdapter.CourseChecklistHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_coursechecklist, parent, false);
        return new CourseChecklistAdapter.CourseChecklistHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseChecklistAdapter.CourseChecklistHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.mCourseName.setText("" + currentCourse.getCourseName());
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
