package com.utcn.facade.populator.habit;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.Habit;
import org.springframework.stereotype.Component;

@Component
public class HabitPopulator implements Populator<Habit, HabitData> {

    @Override
    public void populate(HabitData habitData, Habit habit) {
        habitData.setId(habit.getHabitId());
        habitData.setName(habit.getName());
    }
}

