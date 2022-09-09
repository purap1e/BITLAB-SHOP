//package com.example.demo.controller;
//
//
//import com.example.demo.DBManager;
//import com.example.demo.shop.Description;
//import com.example.demo.shop.Items;
//import com.example.demo.shop.Logins;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.ArrayList;
//
//@Controller
//public class ShopController {
//
//    @GetMapping(value = "/")
//    public String getMainPage(Model model){
//
//        ArrayList<Items> items = DBManager.getItems();
//        model.addAttribute("items",items);
//
//        return "/main-shop-page";
//    }
//
////    @GetMapping(value = "/")
////    public String getSign(){
////        return "redirect:/main-shop-page";
////    }
//
//    @GetMapping(value = "/shop-login")
//    public String getLogin(){
//        return "/sign";
//    }
//
//    @PostMapping(value = "/sign")
//    public String sign(Model model,@RequestParam(name = "email") String email,
//                       @RequestParam(name = "password") String password){
//        Logins l = DBManager.getLogin(email);
//        if(l.getEmail().equals("purap1e@mail.ru")) {
//            ArrayList<Items> items = DBManager.getItems();
//            model.addAttribute("items",items);
//            model.addAttribute("login",l);
//            return "/admins";
//        }
//        if(l!=null){
//            if(l.getPassword().equals(password)){
//                ArrayList<Items> items = DBManager.getItems();
//                model.addAttribute("items",items);
//                model.addAttribute("login",l);
//                return "/main-shop-page-loged";
//            }
//        }
//        return "/main-shop-page";
//    }
//
//    @GetMapping(value = "/logout")
//    public String logout(){
//        return "redirect:/";
//    }
//
//
//    @GetMapping(value = "/register")
//    public String getRegister(){
//        return "/register";
//    }
//
//    @PostMapping(value = "/register")
//    public String register(Model model,@RequestParam(name = "email") String email,
//                           @RequestParam(name = "password") String password,
//                           @RequestParam(name = "re_password") String rePassword,
//                           @RequestParam(name = "full_name") String fullName) {
//        Logins l = DBManager.getLogin(email);
//        if (l==null){
//            if(password.equals(rePassword)){
//                Logins login = new Logins(null,email,password,fullName);
//                DBManager.addLogin(login);
//
//                ArrayList<Items> items = DBManager.getItems();
//                model.addAttribute("items",items);
//                model.addAttribute("login",login);
//                return "/main-shop-page-loged";
//            }
//        }
//        return "/main-shop-page";
//    }
//
//    @GetMapping(value = "/addItem")
//    public String add(){
//        return "/main-shop-page-loged-admin";
//    }
//    @PostMapping(value = "/addItem")
//    public String addItem(@RequestParam(name = "name") String name,
//                          @RequestParam(name = "ram") String ram,
//                          @RequestParam(name = "memory") String memory,
//                          @RequestParam(name = "processor") String processor,
//                          @RequestParam(name = "price") Double price) {
//
//        Items item = new Items(null,name, new Description(ram,memory,processor),price);
//        DBManager.addItem(item);
//
//        return "/main-shop-page-loged-admin";
//    }
//}
