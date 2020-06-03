package com.utcn.service.habit.impl;

import com.utcn.dao.habit.HabitDao;
import com.utcn.model.Habit;
import com.utcn.service.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class HabitServiceImpl implements HabitService {

    @Autowired
    private HabitDao habitDao;

    @Override
    public void add(Habit habit) {
        habitDao.save(habit);
    }

    @Override
    public List<Habit> getAll() {
        return habitDao.getAll();
    }

    @Override
    public Habit update(Habit habit) {
        Optional<Habit> foundHabit = habitDao.getById(habit.getHabitId());
        String habitName = habit.getName();
        String oldHabitName = foundHabit.get().getName();

        if (isNameAlreadyUsed(habitName)) {
            if (!oldHabitName.equals(habitName)) {
                throw new IllegalArgumentException("Habit name already used!");
            }
        } else {
            habitDao.update(habit);
        }

        return habit;
    }

    @Override
    public Habit getHabitByName(String name) {
        Optional<Habit> habit = habitDao.getByName(name);
        return habit.orElse(null);
    }

    @Override
    public Habit findById(Integer id) {
        Optional<Habit> habit = habitDao.getById(id);
        return habit.orElse(null);
    }

    @Override
    public void delete(Integer id) {
        habitDao.getById(id).ifPresentOrElse(habit -> {
                    habitDao.delete(id);
                }, () -> {
                    throw new NoSuchElementException("habit-not-found");
                }
        );
    }

    private Boolean isNameAlreadyUsed(String name) {
        return getHabitByName(name) != null;
    }
}
