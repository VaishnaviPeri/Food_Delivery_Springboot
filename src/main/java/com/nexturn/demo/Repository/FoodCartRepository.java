package com.nexturn.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Restaurants;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{
//	Optional<FoodCart> findByCart_id(Integer cart_id);
	
	@Query("SELECT fc FROM FoodCart fc  WHERE fc.cart_id = ?1")
	List<FoodCart> findByCartId(Integer cart_id) throws FoodCartException;

}
