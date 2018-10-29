package repositories;

import repositories.base.DataRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T> implements DataRepository<T> {
    private final List<T> values;

    public InMemoryRepository() {
        this.values = new ArrayList<>();
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(this.values);
    }

    @Override
    public void insert(T object) {
        this.values.add(object);
    }
}
