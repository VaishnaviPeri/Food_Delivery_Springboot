package com.nexturn.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Restaurants;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer>{
	
	Optional<Restaurants> findByManager_name(String manager_name);

}
