package repositories;

import entities.DbEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import repositories.base.DataRepository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class HibernateDataRepository<T extends DbEntity> implements DataRepository<T> {
    private final Class<T> klass;
    private final SessionFactory sessionFactory;

    public HibernateDataRepository(SessionFactory sessionFactory, Class<T> klass) {
        this.sessionFactory = sessionFactory;
        this.klass = klass;
    }

    @Override
    public List<T> listAll() {
        Session session = sessionFactory.openSession();
        CriteriaQuery<T> query = session.getCriteriaBuilder()
                .createQuery(klass);

        query.from(klass);

        List<T> entities = session.createQuery(query).getResultList();

        session.close();
        return entities;
    }

    @Override
    public T find(long id) {
        Session session = sessionFactory.openSession();
        T entity = session.find(klass, id);

        session.close();
        return entity;
    }

    @Override
    public void add(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void delete(T entity) {
        delete(entity.getId());
    }

    @Override
    public void delete(long id) {
        T entity = find(id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

    @Override
    public void update(T entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(entity);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(long id, T entity) {
        entity.setId(id);
    }
}
