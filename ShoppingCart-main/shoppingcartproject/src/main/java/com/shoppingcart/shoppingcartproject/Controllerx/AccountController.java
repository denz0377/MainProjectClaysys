package com.shoppingcart.shoppingcartproject.Controllerx;

import com.shoppingcart.shoppingcartproject.Modelx.AccountDetail;
import com.shoppingcart.shoppingcartproject.Modelx.User;
import com.shoppingcart.shoppingcartproject.Repo.UserRepository;
import com.shoppingcart.shoppingcartproject.Servicex.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AccountController {

    @Autowired
    public AccountServiceImpl accountServiceImpl;
    @Autowired
    public UserRepository userRepository;


    @GetMapping("/accountAdd")
    public String showAccountRegistrationForm(Model model) {
       AccountDetail account= new AccountDetail ();
        List<User> user =userRepository.findAll();
        model.addAttribute("account", new AccountDetail());
        model.addAttribute("user",user );
        return "account_form";

    }

    @PostMapping("/accountSave")
    public String processRegister(@ModelAttribute("account")  AccountDetail account) {
        accountServiceImpl.saveAccount(account);
        return "redirect:/accountList";
    }


    @GetMapping("/accountList")
    public String listAccount(Model model) {
        List<AccountDetail> listAccount = accountServiceImpl.getAllAccount();
        model.addAttribute("listAccount", listAccount);

        return "account";
    }

    @GetMapping("/showUpdateFormAccount/{id}")
    public String showCartUpdateForm(@PathVariable(value = "id") int id, Model model) {
        List<User> user = userRepository.findAll();
        AccountDetail account = accountServiceImpl.getAccountById(id);
        model.addAttribute("account", account);
        model.addAttribute("user", user);
        return "update_account";
    }


    @GetMapping("/deleteAccount/{id}")
    public String deleteAccount(@PathVariable(value = "id") int id) {


        this.accountServiceImpl.deleteAccountById(id);
        return "redirect:/accountList";
    }


}
