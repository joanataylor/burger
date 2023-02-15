package com.joana.burger.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.joana.burger.models.Burger;
import com.joana.burger.services.BurgerService;

@Controller
public class BurgerController {
  @Autowired
  BurgerService burgerService;

    @RequestMapping("/")
    public String allBurgers(Model model, @ModelAttribute("burger") Burger burger){
      List<Burger> burguers = burgerService.allBurgers();
      model.addAttribute("burgers", burguers);
      return "index.jsp";
    }

    @PostMapping("/burgers")
      public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result, Model model) {
        if (result.hasErrors()){
          List<Burger> burguers = burgerService.allBurgers();
          model.addAttribute("burgers", burguers);
          return "index.jsp";
        } else {
        burgerService.createBurger(burger);
        return "redirect:/";
      }
    }
  }

