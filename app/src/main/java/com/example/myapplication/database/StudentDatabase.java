package com.example.myapplication.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.myapplication.database.dao.CourseDao;
import com.example.myapplication.database.dao.MentorDao;
import com.example.myapplication.database.dao.TermDao;
import com.example.myapplication.database.model.Course;
import com.example.myapplication.database.model.Mentor;
import com.example.myapplication.database.model.Term;

@Database(entities = {Term.class, Course.class, Mentor.class}, version = 1)
// @TypeConverters({Converters.class})
public abstract class StudentDatabase extends RoomDatabase {

    private static StudentDatabase instance;
    public abstract TermDao termDao();
    public abstract CourseDao courseDao();
    public abstract MentorDao mentorDao();

    public static synchronized StudentDatabase getInstance(Context c) {
        if (instance == null) {
            instance = Room.databaseBuilder(c.getApplicationContext(), StudentDatabase.class, "student_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private TermDao termDao;
        private CourseDao courseDao;
        private MentorDao mentorDao;

        private PopulateDbAsyncTask(StudentDatabase db) {
            termDao = db.termDao();
            courseDao = db.courseDao();
            mentorDao = db. mentorDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            /** POPULATE DB WITH TERMS */

            Term currentTerm = new Term();
            currentTerm.setTermTitle("Current Term");
            currentTerm.setStart("Test");
            currentTerm.setEnd("Test");
            termDao.insert(currentTerm);

            Term nextTerm = new Term();
            nextTerm.setTermTitle("Next Term");
            nextTerm.setStart("Test");
            nextTerm.setEnd("Test");
            termDao.insert(nextTerm);

            Term futureTerm = new Term();
            futureTerm.setTermTitle("Future Term");
            futureTerm.setStart("Test");
            futureTerm.setEnd("Test");
            termDao.insert(futureTerm);

            /** POPULATE DB WITH MENTORS */

            Mentor at = new Mentor();
            at.setMentorName("Alan Turing");
            at.setMentorPhone("800-000-000");
            at.setMentorEmail("fatherof@computerscience.com");

            Mentor ae = new Mentor();
            ae.setMentorName("Albert Einstein");
            ae.setMentorPhone("800-000-000");
            ae.setMentorEmail("lawsof@physics.com");

            Mentor ws = new Mentor();
            ws.setMentorName("William Shakespeare");
            ws.setMentorPhone("800-000-000");
            ws.setMentorEmail("english@era.com");

            Mentor mc = new Mentor();
            mc.setMentorName("Marie Curie");
            mc.setMentorPhone("800-000-000");
            mc.setMentorEmail("twotimefemale@nobelprize.com");

            Mentor al = new Mentor();
            al.setMentorName("Ada Lovelace");
            al.setMentorPhone("800-000-000");
            al.setMentorEmail("female@analytic.com");

            Mentor bo = new Mentor();
            bo.setMentorName("Barack Obama");
            bo.setMentorPhone("800-000-000");
            bo.setMentorEmail("fortyfour@potus.com");

            mentorDao.insert(at);
            mentorDao.insert(ae);
            mentorDao.insert(ws);
            mentorDao.insert(mc);
            mentorDao.insert(al);
            mentorDao.insert(bo);

            /** POPULATE DB WITH COURSES
             * FIGURE OUT HOW TO IMPLEMENT FK TO ASSOCIATE
             * WITH TERMS AND MENTORS */

            // TODO

            Course eng = new Course();
            eng.setCourseName("English");
            eng.setStart("Test");
            eng.setEnd("Test");
            courseDao.insert(eng);

            Course alg = new Course();
            alg.setCourseName("Algebra");
            alg.setStart("Test");
            alg.setEnd("Test");
            courseDao.insert(alg);

            Course phys = new Course();
            phys.setCourseName("Physics");
            phys.setStart("Test");
            phys.setEnd("Test");
            courseDao.insert(phys);

            Course bio = new Course();
            bio.setCourseName("Biology");
            bio.setStart("Test");
            bio.setEnd("Test");
            courseDao.insert(bio);

            Course calc = new Course();
            calc.setCourseName("Calculus");
            calc.setStart("Test");
            calc.setEnd("Test");
            courseDao.insert(calc);

            Course cs = new Course();
            cs.setCourseName("Algorithms");
            cs.setStart("Test");
            cs.setEnd("Test");
            courseDao.insert(cs);

            Course polisci = new Course();
            polisci.setCourseName("Political Science");
            polisci.setStart("Test");
            polisci.setEnd("Test");
            courseDao.insert(polisci);

            Course chem = new Course();
            chem.setCourseName("Chemistry");
            chem.setStart("Test");
            chem.setEnd("Test");
            courseDao.insert(chem);

            Course psych = new Course();
            psych.setCourseName("Psychology");
            psych.setStart("Test");
            psych.setEnd("Test");
            courseDao.insert(psych);

            Course stats = new Course();
            stats.setCourseName("Statistics");
            stats.setStart("Test");
            stats.setEnd("Test");
            courseDao.insert(stats);

            return null;
        }
    }
}