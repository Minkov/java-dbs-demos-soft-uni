package repositories;

import repositories.base.DataRepository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class JdbcDataRepository<T> implements DataRepository<T> {
    private static final String SELECT_QUERY_TEMPLATE = "SELECT * FROM {0}";
    private static final String SELECT_BY_ID_QUERY_TEMPLATE = "SELECT * FROM {0} WHERE id='{1}'";
    private final Connection connection;
    private final Class<T> klass;

    JdbcDataRepository(Connection connection, Class<T> klass) {
        this.connection = connection;
        this.klass = klass;
    }

    @Override
    public List<T> listAll() throws SQLException {
        String queryString =
                buildQueryString(SELECT_QUERY_TEMPLATE, new Object[]{getTableName()});
        ResultSet resultSet = connection.prepareStatement(queryString)
                .executeQuery();

        return toList(resultSet);
    }

    private List<T> toList(ResultSet resultSet) throws SQLException {
        List<T> result = new ArrayList<>();

        while (resultSet.next()) {
            result.add(extractEntity(result));
        }

        return result;
    }

    @Override
    public T find(long id) throws SQLException {
        String queryString =
                buildQueryString(SELECT_BY_ID_QUERY_TEMPLATE, new Object[]{getTableName(), id});
        ResultSet resultSet = connection.prepareStatement(queryString)
                .executeQuery();

        return toList(resultSet)
                .get(0);
    }

    @Override
    public void add(T entity) {
        String[] columnNames = getColumnNames();
        Object[] values =
    }

    @Override
    public void delete(T entity) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void update(T entity) {

    }

    @Override
    public void update(long id, T entity) {

    }

    private String getTableName() {
        return klass.getSimpleName();
    }

    private String buildQueryString(String template, Object[] args) {
        return MessageFormat.format(template, args);
    }

    protected abstract String[] getColumnNames();

    protected abstract T extractEntity(List<T> result);
}
