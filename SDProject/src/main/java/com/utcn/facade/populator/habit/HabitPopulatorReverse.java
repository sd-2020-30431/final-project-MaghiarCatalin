package com.utcn.facade.populator.habit;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.populator.Populator;
import com.utcn.model.Habit;
import org.springframework.stereotype.Component;

@Component
public class HabitPopulatorReverse implements Populator<HabitData, Habit> {

    @Override
    public void populate(Habit habit, HabitData habitData) {
        habit.setHabitId(habitData.getId());
        habit.setName(habitData.getName());
    }
}
