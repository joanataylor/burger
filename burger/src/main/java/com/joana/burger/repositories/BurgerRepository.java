package com.joana.burger.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joana.burger.models.Burger;

@Repository
public interface BurgerRepository extends CrudRepository<Burger, Long>{
    // this method retrieves all the Burgers from the database
    List<Burger> findAll();
    // this method finds Burgers with restaurants containing the search string
    List<Burger> findByRestaurantContaining(String search);
    // this method counts how many names contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a Burger that starts with a specific name
    Long deleteByNameStartingWith(String search);
}
