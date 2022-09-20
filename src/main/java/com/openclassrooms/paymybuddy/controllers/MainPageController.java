package com.openclassrooms.paymybuddy.controllers;

//import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController
{

//    @GetMapping("/main")
//    public String main(Authentication a, Model model)
//    {
//
//        try
//        {
//            System.out.println("** Main Controller Called **   ** Main Controller Called **   ** Main Controller Called **   ");
//            System.out.println(a.getName());
//            model.addAttribute("username", a.getName());
//            System.out.println("model.containsAttribute(username) : " + model.containsAttribute("username"));
//        }
//        catch (RuntimeException runtimeException)
//        {
//            System.out.println(runtimeException.getMessage());
//        }
//
//        return "main.html";
//    }
}