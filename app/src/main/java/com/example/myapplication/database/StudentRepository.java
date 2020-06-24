package com.example.myapplication.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import com.example.myapplication.database.dao.CourseDao;
import com.example.myapplication.database.dao.MentorDao;
import com.example.myapplication.database.dao.TermDao;
import com.example.myapplication.database.model.Course;
import com.example.myapplication.database.model.Mentor;
import com.example.myapplication.database.model.Term;
import java.util.List;


/** TODO
 * Initialize in THIS REPOSITORY'S CONSTRUCTOR
*/

public class StudentRepository {
    private TermDao termDao;
    private CourseDao courseDao;
    private MentorDao mentorDao;
    private LiveData<List<Term>> allTerms;
    private LiveData<List<Course>> allCourses;
    private LiveData<List<Mentor>> allMentors;

    public StudentRepository(Application application) {
        StudentDatabase db = StudentDatabase.getInstance(application);
        termDao = db.termDao();
        courseDao = db.courseDao();
        mentorDao = db.mentorDao();
        allTerms = termDao.getAllTerms();
        allCourses = courseDao.getAllCourses();
        allMentors = mentorDao.getAllMentors();
    }

    /** T E R M S */

    public void insertTerm(Term term) {
        new InsertTermAsyncTask(termDao).execute(term);
    }
    public void updateTerm(Term term) {
        new UpdateTermAsyncTask(termDao).execute(term);
    }
    public void deleteTerm(Term term) {
        new DeleteTermAsyncTask(termDao).execute(term);
    }
    public void deleteAllTerms() {
        new DeleteAllTermsAsyncTask(termDao).execute();
    }
    public LiveData<List<Term>> getAllTerms() {
        return allTerms;
    }

    public static class InsertTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDao termDao;

        private InsertTermAsyncTask(TermDao termDao) {
            this.termDao = termDao;
        }
        @Override
        protected Void doInBackground(Term... terms) {
            termDao.insert(terms[0]);
            return null;
        }
    }

    public static class UpdateTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDao termDao;

        private UpdateTermAsyncTask(TermDao termDao) {
            this.termDao = termDao;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDao.update(terms[0]);
            return null;
        }
    }

    public static class DeleteTermAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDao termDao;

        private DeleteTermAsyncTask(TermDao termDao) {
            this.termDao = termDao;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDao.delete(terms[0]);
            return null;
        }
    }

    public static class DeleteAllTermsAsyncTask extends AsyncTask<Term, Void, Void> {
        private TermDao termDao;

        private DeleteAllTermsAsyncTask(TermDao termDao) {
            this.termDao = termDao;
        }

        @Override
        protected Void doInBackground(Term... terms) {
            termDao.deleteAllTerms();
            return null;
        }
    }

    /** C O U R S E S **/

    public void insertCourse(Course course) {
        new InsertCourseAsyncTask(courseDao).execute(course);
    }
    public void updateCourse(Course course) {
        new UpdateCourseAsyncTask(courseDao).execute(course);
    }
    public void deleteCourse(Course course) {
        new DeleteCourseAsyncTask(courseDao).execute(course);
    }
    public void deleteAllCourses() {
        new DeleteAllCoursesAsyncTask(courseDao).execute();
    }
    public LiveData<List<Course>> getAllCourses() {
        return allCourses;
    }

    public static class InsertCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDao courseDao;

        private InsertCourseAsyncTask(CourseDao courseDao) {
            this.courseDao = courseDao;
        }
        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.insert(courses[0]);
            return null;
        }
    }
    public static class UpdateCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDao courseDao;

        private UpdateCourseAsyncTask(CourseDao courseDao) {
            this.courseDao = courseDao;
        }
        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.update(courses[0]);
            return null;
        }
    }

    public static class DeleteCourseAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDao courseDao;

        private DeleteCourseAsyncTask(CourseDao courseDao) {
            this.courseDao = courseDao;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.delete(courses[0]);
            return null;
        }
    }
    public static class DeleteAllCoursesAsyncTask extends AsyncTask<Course, Void, Void> {
        private CourseDao courseDao;

        private DeleteAllCoursesAsyncTask(CourseDao courseDao) {
            this.courseDao = courseDao;
        }

        @Override
        protected Void doInBackground(Course... courses) {
            courseDao.deleteAllCourses();
            return null;
        }
    }

    /** M E N T O R S **/

    public void insertMentor(Mentor mentor) {
        new InsertMentorAsyncTask(mentorDao).execute(mentor);
    }
    public void updateMentor(Mentor mentor) {
        new UpdateMentorAsyncTask(mentorDao).execute(mentor);
    }
    public void deleteMentor(Mentor mentor) {
        new DeleteMentorAsyncTask(mentorDao).execute(mentor);
    }
    public void deleteAllMentors() {
        new DeleteAllMentorsAsyncTask(mentorDao).execute();
    }
    public LiveData<List<Mentor>> getAllMentors() {
        return allMentors;
    }

    public static class InsertMentorAsyncTask extends AsyncTask<Mentor, Void, Void> {
        private MentorDao mentorDao;

        private InsertMentorAsyncTask(MentorDao mentorDao) {
            this.mentorDao = mentorDao;
        }
        @Override
        protected Void doInBackground(Mentor... mentors) {
            mentorDao.insert(mentors[0]);
            return null;
        }
    }
    public static class UpdateMentorAsyncTask extends AsyncTask<Mentor, Void, Void> {
        private MentorDao mentorDao;

        private UpdateMentorAsyncTask(MentorDao mentorDao) {
            this.mentorDao = mentorDao;
        }
        @Override
        protected Void doInBackground(Mentor... mentors) {
            mentorDao.update(mentors[0]);
            return null;
        }
    }

    public static class DeleteMentorAsyncTask extends AsyncTask<Mentor, Void, Void> {
        private MentorDao mentorDao;

        private DeleteMentorAsyncTask(MentorDao mentorDao) {
            this.mentorDao = mentorDao;
        }

        @Override
        protected Void doInBackground(Mentor... mentors) {
            mentorDao.delete(mentors[0]);
            return null;
        }
    }

    public static class DeleteAllMentorsAsyncTask extends AsyncTask<Mentor, Void, Void> {
        private MentorDao mentorDao;

        private DeleteAllMentorsAsyncTask(MentorDao mentorDao) {
            this.mentorDao = mentorDao;
        }

        @Override
        protected Void doInBackground(Mentor... mentors) {
            mentorDao.deleteAllMentors();
            return null;
        }
    }
}
