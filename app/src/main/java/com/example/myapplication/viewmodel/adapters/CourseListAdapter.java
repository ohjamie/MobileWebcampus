package com.example.myapplication.viewmodel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.C196PA.R;
import com.example.myapplication.database.model.CourseModel;
import com.example.myapplication.viewmodel.holders.CourseListHolder;

import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<CourseListHolder> {

    Context c;
    ArrayList<CourseModel> courses;

    public CourseListAdapter(Context c, ArrayList<CourseModel> courses) {
        this.c = c;
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_courses, null);

        return new CourseListHolder(view); // return view to holder class
    }

    @Override
    public void onBindViewHolder(@NonNull CourseListHolder holder, int position) {
        holder.mCourseNumber.setText("" + courses.get(position).getCourseId());
        holder.mCourseTitle.setText(courses.get(position).getCourseTitle());
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }

}
