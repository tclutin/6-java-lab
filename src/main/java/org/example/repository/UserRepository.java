package org.example.repository;

import org.example.accounts.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class UserRepository{

    private SessionFactory sessionFactory;

    public UserRepository() {
        this.sessionFactory = new DbContext().createSessionFactory();
    }

    public void createUser(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public User getUser(String login) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        User user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        session.close();
        return user;
    }
}
