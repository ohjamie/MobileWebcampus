package com.example.myapplication.C196PA;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseListHolder extends RecyclerView.ViewHolder {

        public TextView mCourseNumber;
        public TextView mCourseTitle;

        public CourseListHolder(@NonNull View itemView) {
            super(itemView);

            this.mCourseNumber = itemView.findViewById(R.id.courseNumber);
            this.mCourseTitle = itemView.findViewById(R.id.courseTitle);
        }
}
