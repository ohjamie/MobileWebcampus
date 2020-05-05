package com.example.myapplication.viewmodel.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.myapplication.C196PA.CourseListHolder;
import com.example.myapplication.C196PA.R;
import com.example.myapplication.database.model.CourseModel;
import java.util.ArrayList;

public class CourseListAdapter extends RecyclerView.Adapter<com.example.myapplication.C196PA.CourseListHolder> {

    Context c;
    ArrayList<CourseModel> courses;

    public CourseListAdapter(Context c, ArrayList<CourseModel> courses) {
        this.c = c;
        this.courses = courses;
    }

    @NonNull
    @Override
    public com.example.myapplication.C196PA.CourseListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_courses, null);

        return new com.example.myapplication.C196PA.CourseListHolder(view); // return view to holder class
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
