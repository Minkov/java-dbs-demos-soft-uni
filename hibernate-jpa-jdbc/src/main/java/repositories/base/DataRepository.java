package repositories.base;

import java.sql.SQLException;
import java.util.List;

public interface DataRepository<T> {
    List<T> listAll() throws SQLException;

    T find(long id) throws SQLException;

    void add(T entity);

    void delete(T entity);

    void delete(long id);

    void update(T entity);

    void update(long id, T entity);
}
