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

public class CourseListAdapter extends RecyclerView.Adapter<CourseListAdapter.CourseListHolder> {

    private List<Course> courses = new ArrayList<>();
    private OnItemClickListener listener;

    class CourseListHolder extends RecyclerView.ViewHolder {

        public TextView mCourseName;
        public TextView mDuration;

        public CourseListHolder(@NonNull View itemView) {
            super(itemView);

            this.mCourseName = itemView.findViewById(R.id.course_name);
            this.mDuration = itemView.findViewById(R.id.course_duration);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(courses.get(position));
                    }
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Course course);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CourseListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_courses, parent, false);
        return new CourseListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListHolder holder, int position) {
        Course currentCourse = courses.get(position);
        holder.mCourseName.setText("" + currentCourse.getCourseName());
        holder.mDuration.setText(currentCourse.getStart() + " to " + currentCourse.getEnd());
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