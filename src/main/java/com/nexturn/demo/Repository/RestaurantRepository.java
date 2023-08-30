package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nexturn.demo.Model.Restaurants;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer>{

}
