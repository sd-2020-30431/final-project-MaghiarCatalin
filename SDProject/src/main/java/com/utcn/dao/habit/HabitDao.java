package com.utcn.dao.habit;

import com.utcn.model.Habit;

import java.util.List;
import java.util.Optional;

public interface HabitDao {

    List<Habit> getAll();

    void update(Habit habit);

    Optional<Habit> getById(Integer id);

    Optional<Habit> getByName(String name);

    void save(Habit habit);

    void delete(Integer id);

}
