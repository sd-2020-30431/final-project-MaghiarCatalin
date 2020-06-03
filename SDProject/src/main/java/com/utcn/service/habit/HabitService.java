package com.utcn.service.habit;

import com.utcn.model.Habit;

import java.util.List;

public interface HabitService {

    void add(Habit habit);

    List<Habit> getAll();

    Habit update(Habit habit);

    Habit getHabitByName(String name);

    Habit findById(Integer id);

    void delete(Integer id);
}
