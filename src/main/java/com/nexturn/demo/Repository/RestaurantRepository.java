package com.nexturn.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.ExceptionHandling.UsernameNotFoundException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.Restaurants;
import com.nexturn.demo.Model.User;

import java.util.List;



@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants, Integer>{
	
	Optional<Restaurants> findByManager_name(String manager_name);
	
	@Query("SELECT r FROM Restaurants r WHERE r.restaurant_name = ?1")
	Restaurants findByRestaurantname(String restaurant) throws RestaurantException;

}
