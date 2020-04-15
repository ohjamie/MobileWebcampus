package dao;

import com.example.c196pa.Term;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class TermDao implements Dao<Term> {

    private List<Term> allTerms = new ArrayList<>();

    // change this to initialize to get from db later
    // TODO: implement JDBC

    public TermDao() {
        allTerms.add(1, "Last Semester", LocalDateTime.now(), LocalDateTime.now().plusWeeks(3), 1);
    }

    @Override
    public Optional<Term> get(long id) {
        return Optional.ofNullable(allTerms.get((int) id));
    }

    @Override
    public List<Term> getAll() {
        return allTerms;
    }

    @Override
    public void save(Term term) {
        allTerms.add(term);
    }

    @Override
    public void update(Term term, String[] params) {
        term.setTitle(Objects.requireNonNull(params[0], "Cannot be null"));
        term.setStartDate(Objects.requireNonNull(params[0], "Cannot be null"));
        term.setEndDate((Objects.requireNonNull(params[0], "Cannot be null")));
        term.setCurrent(Objects.requireNonNull(params[0], "Cannot be null"));
    }

    @Override
    public void delete(Term term) {
        allTerms.remove(term);
    }
}
