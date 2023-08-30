package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.FoodCart;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{

}
