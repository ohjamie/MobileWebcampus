

import com.example.c196pa.Term;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import dao.Dao;

public class TermDao implements Dao<Term> {

    private List<Term> allTerms = new ArrayList<>();

    public TermDao() {
        // allTerms.add(new Term(1, "Last Semester"));
    }

    @Override
    public Optional<Term> get(int id) {
        return Optional.ofNullable(allTerms.get(id));
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
        allTerms.add(term);
    }

    @Override
    public void delete(Term term) {
        allTerms.remove(term);
    }
}