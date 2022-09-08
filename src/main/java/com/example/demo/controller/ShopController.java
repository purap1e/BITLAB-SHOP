package com.example.demo.controller;


import com.example.demo.DBManager;
import com.example.demo.shop.Items;
import com.example.demo.shop.Logins;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ShopController {

    @GetMapping(value = "/main-shop-page")
    public String getMainPage(Model model){

        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("items",items);

        return "/main-shop-page";
    }

    @GetMapping(value = "/")
    public String getSign(){
        return "redirect:/main-shop-page";
    }

    @GetMapping(value = "/shop-login")
    public String getLogin(){
        return "/sign";
    }

    @PostMapping(value = "/sign")
    public String sign(Model model,@RequestParam(name = "email") String email,
                       @RequestParam(name = "password") String password){
        Logins l = DBManager.getLogin(email);
        if(l!=null){
            if(l.getPassword().equals(password)){
                ArrayList<Items> items = DBManager.getItems();
                model.addAttribute("items",items);
                model.addAttribute("login",l);
                return "/main-shop-page-loged";
            }
        }
        return "/";
    }

    @GetMapping(value = "/logout")
    public String logout(){
        return "redirect:/main-shop-page";
    }


    @GetMapping(value = "/register")
    public String getRegister(){
        return "/register";
    }

    @PostMapping(value = "/register")
    public String register(Model model,@RequestParam(name = "email") String email,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "re_password") String rePassword,
                           @RequestParam(name = "full_name") String fullName) {
        Logins l = DBManager.getLogin(email);
        if (l==null){
            if(password.equals(rePassword)){
                Logins login = new Logins(null,email,password,fullName);
                DBManager.addLogin(login);

                ArrayList<Items> items = DBManager.getItems();
                model.addAttribute("items",items);
                model.addAttribute("login",login);
                return "/main-shop-page-loged";
            }
        }
        return "/";
    }
}
