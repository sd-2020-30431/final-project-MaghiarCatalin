package com.utcn.data.habit;

import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Validated
public class HabitData {

    private Integer id;

    @NotEmpty(message = "The name must be between 3 and 5 characters")
    @Size(min = 3, max = 25)
    private String name;

    public HabitData(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public HabitData() {
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
