package com.utcn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "habits")
public class Habit {

    private Integer habitId;
    private String name;

    public Habit() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habitId")
    public Integer getHabitId() {
        return habitId;
    }

    public void setHabitId(Integer habitId) {
        this.habitId = habitId;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
