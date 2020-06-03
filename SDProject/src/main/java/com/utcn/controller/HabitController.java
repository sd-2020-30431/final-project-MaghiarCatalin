package com.utcn.controller;

import com.utcn.data.habit.HabitData;
import com.utcn.facade.habit.HabitFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.NoSuchElementException;

@Controller
@RequestMapping("/habits")
public class HabitController {

    @Autowired
    private HabitFacade habitFacade;

    @GetMapping
    public String getAll(@ModelAttribute("habitDto") HabitData habitData, Model model) {
        model.addAttribute("habits", habitFacade.getAll());
        model.addAttribute("habitDto", habitData);
        return "habit/all-habit";
    }

    @GetMapping("/add-habit")
    public String showAdd(Model model) {
        model.addAttribute("habitDto", new HabitData());
        return "habit/all-habit";
    }

    @PostMapping("/add-habit")
    public String addHabit(@Valid @ModelAttribute("habitDto") HabitData habitData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("Error", "Invalid");
            return "redirect:/habits";
        } else {
            try {
                habitFacade.save(habitData);
                model.addAttribute("Name", habitData.getName());
                model.addAttribute("Success", "Habit successfully added.");
            } catch (IllegalArgumentException exception) {
                model.addAttribute("Error", exception.getMessage());
                return "redirect:/habits";
            }
        }
        model.addAttribute("habitDto", new HabitData());
        model.addAttribute("habits", habitFacade.getAll());
        return "habit/all-habit";
    }

    @PostMapping("/update")
    public String update(@Validated HabitData habitData, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            FieldError fieldError = bindingResult.getFieldError();

            if (fieldError.getField().equals("id")) {
                model.addAttribute("status", "ID invalid!");
            } else {
                model.addAttribute("status", "The habit name must be between 3 and 5 characters!");
            }
        }

        try {
            model.addAttribute("habit", habitFacade.update(habitData));
        } catch (IllegalArgumentException illegalArgException) {
            model.addAttribute("status", "Habit name already used!");
        } catch (NoSuchElementException noSuchElementException) {
            model.addAttribute("status", "The habit you want to update is nonexistent!");
        }

        return "habit-update-fragment";
    }

    @PostMapping("/{habitId}")
    public String deleteHabit(Model model, @PathVariable("habitId") Integer id) {
        try {
            habitFacade.delete(id);
            model.addAttribute("status", "Habit deleted");
            return "habit-delete-fragment";
        } catch (Exception e) {
            model.addAttribute("status", e.getMessage());
            return "habit-delete-fragment";
        }
    }
}