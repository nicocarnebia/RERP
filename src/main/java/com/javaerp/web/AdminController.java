package com.javaerp.web;

import com.javaerp.model.User;
import com.javaerp.service.RoleServiceImpl;
import com.javaerp.service.SecurityService;
import com.javaerp.service.UserService;
import com.javaerp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/admin/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "admin/registration";
    }

    @RequestMapping(value = "/admin/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "admin/registration";
        }
        userForm.setRole(roleService.findByName("ROLE_ADMIN"));
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String index() {
        return "admin/welcome";
    }

    @RequestMapping(value = "/admin/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "admin/login";
    }

}
