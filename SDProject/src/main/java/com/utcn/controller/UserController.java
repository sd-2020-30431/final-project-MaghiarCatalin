package com.utcn.controller;

import com.utcn.data.user.UserData;
import com.utcn.data.user.UserViewData;
import com.utcn.facade.converter.user.UserConverter;
import com.utcn.facade.user.UserFacade;
import com.utcn.model.User;
import com.utcn.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserFacade userFacade;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserConverter userConverter;

    @GetMapping("/login")
    public String login(Authentication authentication) {
        return "user/login";
    }

    @GetMapping("/update-account")
    public String updateUser(Authentication authentication, Model model) throws NoSuchElementException {
        Optional<User> optionalUser = userFacade.getUserByEmail(authentication.getName());
        if (optionalUser.isEmpty()) {
            return "error";
        }
        model.addAttribute("user", userConverter.convert(optionalUser.get()));
        return "user/update-user";
    }

    @PostMapping("/update-account")
    public String updateUser(Authentication authentication, @Valid @ModelAttribute("user") UserViewData userViewData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            errorList.forEach(errorField ->
                    model.addAttribute(errorField.getField() + "_error", userValidator.getErrorMessage(errorField)));
        } else {
            try {
                userFacade.updateUserAccount(authentication.getName(), userViewData);
                model.addAttribute("status", "The information was successfully updated!");
            } catch (UsernameNotFoundException | IllegalArgumentException e) {
                model.addAttribute("status", "Invalid update!");
            }
        }
        return "user/update-user";
    }

    @GetMapping("/update/{email:.+}")
    public String getUpdateAdminPage(@PathVariable("email") String email, Model model) throws NoSuchElementException {
        Optional<User> optionalUser = userFacade.getUserByEmail(email);
        if (optionalUser.isEmpty()) {
            return "error";
        }
        model.addAttribute("email", email);
        model.addAttribute("user", userConverter.convert(optionalUser.get()));
        return "user/update-admin";
    }

    @PostMapping("/update/{email:.+}")
    public String updateAdminUser(@PathVariable("email") String email, @Valid @ModelAttribute("user") UserViewData userViewData, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            errorList.forEach(errorField ->
                    model.addAttribute(errorField.getField() + "_error", userValidator.getErrorMessage(errorField)));
        } else {
            try {
                userFacade.updateUserAccount(email, userViewData);
                return "redirect:/users";
            } catch (DataIntegrityViolationException e) {
                model.addAttribute("status", "Duplicate phone number");
            }
        }
        return "user/update-admin";
    }

    @GetMapping("/delete/{email:.+}")
    public String deleteUser(@PathVariable("email") String email, Model model) {
        Optional<User> optionalUser = userFacade.getUserByEmail(email);
        if (optionalUser.isEmpty()) {
            return "error";
        }
        model.addAttribute("email", email);
        return "user/delete-admin";
    }

    @PostMapping("/delete/{email:.+}")
    public String deleteUser(@PathVariable("email") String email, Principal principal, HttpServletRequest request) {
        userFacade.deleteUserByEmail(email);
        if (email.equals(principal.getName())) {
            HttpSession session = request.getSession(false);
            SecurityContextHolder.clearContext();
            if (session != null) {
                session.invalidate();
            }
            return "redirect:/";
        }
        return "redirect:/users";
    }

    @GetMapping
    public String listAllUsers(Model model) {
        model.addAttribute("users", userFacade.listAllUsers());
        return "user/list-users";
    }

    @GetMapping(value = "/insert-admin")
    public String insert(Model model) {
        model.addAttribute("user", new UserData());
        return "user/create-admin";
    }

    @PostMapping(value = "/insert-admin")
    public String insert(@Valid @ModelAttribute("user") UserData user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            errorList.forEach(errorField ->
                    model.addAttribute(errorField.getField() + "_error", userValidator.getErrorMessage(errorField)));
        } else {
            try {
                userFacade.insertAdmin(user);
                model.addAttribute("user", new UserData());
                model.addAttribute("status", "The account has been created!");
            } catch (DataIntegrityViolationException exception) {
                model.addAttribute("status", "Invalid email or phone number!");
            }
        }
        return "user/create-admin";
    }

    @GetMapping("/sign-up")
    public String insertCustomer(Model model) {
        model.addAttribute("user", new UserData());
        return "create-customer";
    }

    @PostMapping
    public String insertCustomer(@Valid @ModelAttribute("user") UserData user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            List<FieldError> errorList = bindingResult.getFieldErrors();
            errorList.forEach(errorField ->
                    model.addAttribute(errorField.getField() + "_error", userValidator.getErrorMessage(errorField)));
        } else {
            try {
                userFacade.insertCustomer(user);
                model.addAttribute("user", new UserData());
                model.addAttribute("status", "The account has been created!");
            } catch (DataIntegrityViolationException exception) {
                model.addAttribute("status", "Invalid email or phone number!");
            }
        }
        return "create-customer";
    }

    @GetMapping(value = "/delete-my-account")
    public String getDeleteAccount(Model model, Principal principal) {
        model.addAttribute("email", principal.getName());
        return "user/delete-customer";
    }

    @PostMapping("/delete-my-account")
    public String postDeleteAccount(Principal principal, HttpServletRequest request) {
        String email = principal.getName();
        userFacade.deleteUserByEmail(email);

        HttpSession session = request.getSession(false);
        SecurityContextHolder.clearContext();
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/?message=Your account has been deleted!";
    }
}
