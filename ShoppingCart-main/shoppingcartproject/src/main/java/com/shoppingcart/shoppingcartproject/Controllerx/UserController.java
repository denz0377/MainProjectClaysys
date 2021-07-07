package com.shoppingcart.shoppingcartproject.Controllerx;

import com.shoppingcart.shoppingcartproject.Modelx.User;
import com.shoppingcart.shoppingcartproject.Repo.UserRepository;
import com.shoppingcart.shoppingcartproject.Servicex.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller

public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping("")
    public String viewHomePage() {
        return "welcomepage";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());

        return "signup_form";

    }

    @PostMapping("/process_register")
    public String processRegister(  User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        userServiceImpl.saveUser(user);

        return "welcomepage";
    }

    @GetMapping("/menu")
    public String viewMenuPage()
    {
        return"menu";
    }

       @GetMapping("/user")
    public String listUsers(Model model) {
        List<User> listUsers = userServiceImpl.getAllUser();
        model.addAttribute("listUsers", listUsers);

        return "users";
    }

    @GetMapping("/showUpadteForm/{id}")
    public String showUpadteForm(@PathVariable(value = "id") long id, Model model) {
        User user = userServiceImpl.getUserById(id);
        model.addAttribute("user", user);
        return "update_user";
    }



    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable (value = "id") long id) {


        this.userServiceImpl.deleteUserById(id);
        return "redirect:/user";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null)
            new SecurityContextLogoutHandler().logout(request, response, auth);

        return "redirect:/welcome";
    }

}