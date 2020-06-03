package com.utcn.dao.user.impl;

import com.utcn.dao.HibernateAbstractCrudRepository;
import com.utcn.dao.user.UserDao;
import com.utcn.model.User;
import com.utcn.model.UserRole;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl extends HibernateAbstractCrudRepository<String, User> implements UserDao {

    @Override
    protected Class<User> getValueClass() {
        return User.class;
    }

    @Override
    public Optional<User> getByPhoneNumber(String phoneNumber) {
        Query<User> query = super.getCurrentSession().createQuery("from users where phoneNumber=:phoneNumber ", User.class);
        query.setParameter("phoneNumber", phoneNumber);
        return Optional.ofNullable(query.uniqueResult());
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        Session session = this.getCurrentSession();
        return Optional.ofNullable(session.get(this.getValueClass(), email));
    }

    @Override
    public List<String> getAllUserEmailsByRole(UserRole role) {

        String userClassName = User.class.getName();
        Query<String> query = super.getCurrentSession().createQuery("select user.email from " + userClassName + " user where user.role = :role", String.class);
        query.setParameter("role",role);
        return query.list();
    }
}
