package com.utcn.dao.habit.impl;

import com.utcn.dao.HibernateAbstractCrudRepository;
import com.utcn.dao.habit.HabitDao;
import com.utcn.model.Habit;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class HabitDaoImpl extends HibernateAbstractCrudRepository<Integer, Habit> implements HabitDao {

    @Override
    protected Class<Habit> getValueClass() {

        return Habit.class;
    }

    @Override
    public Optional<Habit> getByName(String name) {
        Query<Habit> query = super.getCurrentSession().createQuery("from Habit where name=:name ", Habit.class);
        query.setParameter("name", name);
        return Optional.ofNullable(query.uniqueResult());
    }

    @Override
    public void save(Habit habit) {
        if (getByName(habit.getName()).isEmpty()) {
            super.save(habit);
        } else {
            throw new IllegalArgumentException("This habit already exists. Choose another name or update the existing one.");
        }
    }
}