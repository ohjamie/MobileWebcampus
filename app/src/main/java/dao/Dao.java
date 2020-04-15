package dao;

import java.util.List;
import java.util.Optional;

// Abstract API to perform CRUD

public interface Dao<T> {
    Optional<T> get(long id);
    List<T> getAll();
    void save(T t);
    void update(T t);
    void delete(T t);
}
