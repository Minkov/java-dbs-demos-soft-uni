package repositories.base;

import java.sql.SQLException;
import java.util.List;

public interface DataRepository<T> {
    List<T> getAll() throws SQLException;

    void insert(T object) throws SQLException;
}
