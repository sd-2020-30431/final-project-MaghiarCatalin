package com.utcn.facade.converter.habit;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.converter.Converter;
import com.utcn.facade.populator.Populator;
import com.utcn.model.Habit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HabitConverter implements Converter<Habit, HabitData> {

    @Autowired
    private Populator<Habit, HabitData> habitDataPopulator;

    @Override
    public HabitData convert(Habit habit) {
        HabitData habitData = new HabitData();
        habitDataPopulator.populate(habitData, habit);
        return habitData;
    }
}