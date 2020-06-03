package com.utcn.facade.habit;

import com.utcn.data.habit.HabitData;
import com.utcn.model.Habit;

import java.util.List;

public interface HabitFacade {

    void save(HabitData habitData);

    Habit update(HabitData habitData);

    List<HabitData> getAll();

    void delete(Integer id);
}
