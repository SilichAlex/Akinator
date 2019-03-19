package com.example.Akinator.repositories;

import com.example.Akinator.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DishRepository extends JpaRepository<Dish,Integer> {

}
