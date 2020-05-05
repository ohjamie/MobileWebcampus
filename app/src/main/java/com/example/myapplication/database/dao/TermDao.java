package com.example.myapplication.C196PA;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import dao.Dao;

public class TermDao implements Dao<TermModel> {

    private List<TermModel> allTerms = new ArrayList<>();

    public TermDao() {
    }

    @Override
    public Optional<TermModel> get(int id) {
        return Optional.ofNullable(allTerms.get(id));
    }

    @Override
    public List<TermModel> getAll() {
        return allTerms;
    }

    @Override
    public void save(TermModel term) {
        allTerms.add(term);
    }

    @Override
    public void update(TermModel term, String[] params) {
        term.setTitle(Objects.requireNonNull(params[0], "Cannot be null"));
        allTerms.add(term);
    }

    @Override
    public void delete(TermModel term) {
        allTerms.remove(term);
    }
}