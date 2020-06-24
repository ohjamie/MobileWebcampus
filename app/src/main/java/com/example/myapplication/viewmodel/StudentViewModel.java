package com.example.myapplication.viewmodel;

/** NOT SURE IF THIS IS NEEDED
 * BUT IF IT IS ADD COURSES AND MENTORS */

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.myapplication.database.StudentRepository;
import com.example.myapplication.database.model.Course;
import com.example.myapplication.database.model.Mentor;
import com.example.myapplication.database.model.Term;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private StudentRepository repository;
    private LiveData<List<Term>> allTerms;
    private LiveData<List<Course>> allCourses;
    private LiveData<List<Mentor>> allMentors;

    public StudentViewModel(@NonNull Application application) {
        super(application);
        repository = new StudentRepository(application);
        allTerms = repository.getAllTerms();
        allCourses = repository.getAllCourses();
        allMentors = repository.getAllMentors();
    }

    public void insertTerm(Term term) {
        repository.insertTerm(term);
    }
    public void updateTerm(Term term) {
        repository.updateTerm(term);
    }
    public void deleteTerm(Term term) {
        repository.deleteTerm(term);
    }
    public void deleteAllTerms() {
        repository.deleteAllTerms();
    }
    public LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    public void insertCourse(Course course) { repository.insertCourse(course); }
    public void updateCourse(Course course) { repository.updateCourse(course); }
    public void deleteCourse(Course course) { repository.deleteCourse(course); }
    public void deleteAllCourses() { repository.deleteAllCourses(); }
    public LiveData<List<Course>> getAllCourses() { return allCourses; }

    public void insertMentor(Mentor mentor) { repository.insertMentor(mentor); }
    public void updateMentor(Mentor mentor) { repository.updateMentor(mentor); }
    public void deleteMentor(Mentor mentor) { repository.deleteMentor(mentor); }
    public void deleteAllMentors() { repository.deleteAllMentors(); }
    public LiveData<List<Mentor>> getAllMentors() { return allMentors; }

}
