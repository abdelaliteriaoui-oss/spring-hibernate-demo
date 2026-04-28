package dao;

import entities.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CategoryDao implements IDao<Category> {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean create(Category category) {
        try {
            sessionFactory.getCurrentSession().save(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Category category) {
        try {
            sessionFactory.getCurrentSession().update(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Category category) {
        try {
            sessionFactory.getCurrentSession().delete(category);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Category findById(int id) {
        return sessionFactory.getCurrentSession().get(Category.class, id);
    }

    @Override
    public List<Category> findAll() {
        return sessionFactory.getCurrentSession()
                .createQuery("from Category", Category.class)
                .list();
    }
}