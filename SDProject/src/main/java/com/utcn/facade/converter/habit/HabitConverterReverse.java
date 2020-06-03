package com.utcn.facade.converter.habit;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HabitConverterReverse implements Converter<HabitData, Habit> {

    @Autowired
    Populator<HabitData, Habit> habitPopulator;

    @Override
    public Habit convert(HabitData habitData) {
        Habit habit = new Habit();
        habitPopulator.populate(habit, habitData);
        return habit;
    }
}
