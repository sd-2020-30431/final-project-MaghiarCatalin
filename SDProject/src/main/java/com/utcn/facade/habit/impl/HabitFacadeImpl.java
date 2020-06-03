package com.utcn.facade.habit.impl;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.habit.HabitFacade;
import com.utcn.model.Habit;
import com.utcn.service.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HabitFacadeImpl implements HabitFacade {

    @Autowired
    private HabitService habitService;

    @Autowired
    private Converter<HabitData, Habit> habitDataHabitConverter;

    @Autowired
    private Converter<Habit, HabitData> habitHabitDataConverter;

    @Override
    public List<HabitData> getAll() {
        return habitHabitDataConverter.convertAll(habitService.getAll());
    }

    public Habit update(HabitData habitData) {
        Habit habit = habitDataHabitConverter.convert(habitData);
        return habitService.update(habit);
    }

    public void save(HabitData habitData) {
        Habit habit = habitDataHabitConverter.convert(habitData);
        habitService.add(habit);
    }

    public void delete(Integer id) {
        habitService.delete(id);
    }
}