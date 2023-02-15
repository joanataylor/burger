package com.joana.burger.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joana.burger.models.Burger;
import com.joana.burger.repositories.BurgerRepository;

@Service
public class BurgerService {
    @Autowired
    BurgerRepository burgerRepository;

    // returns all the burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }

    // creates a burger
    public Burger createBurger(Burger b) {
        return burgerRepository.save(b);
    }

    // retrieves a burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if (optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }

    public Burger updateBurger(Long id, String name, String restaurant, String notes, Integer ratings) {
        return null;
    }

    public void deleteBurger(Long id) {
    }
}
