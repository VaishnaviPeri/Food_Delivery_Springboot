package com.nexturn.demo.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.ExceptionHandling.FoodCartException;
import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.ExceptionHandling.RestaurantException;
import com.nexturn.demo.Model.FoodCart;
import com.nexturn.demo.Model.Restaurants;

@Repository
public interface FoodCartRepository extends JpaRepository<FoodCart, Integer>{
//	Optional<FoodCart> findByCart_id(Integer cart_id);
	
	@Query("SELECT fc FROM FoodCart fc  WHERE fc.cart_id = ?1")
	List<FoodCart> findByCartId(Integer cart_id) throws FoodCartException;
	
	@Query("select fc from FoodCart fc where fc.cart_id= :cart_id ORDER BY fc.id DESC ")
	Optional<FoodCart> findByCartId1(@Param("cart_id") Integer cart_id) throws FoodCartException;

	
	@Query("SELECT fc FROM FoodCart fc  WHERE fc.cart_id = ?1")
	FoodCart findByCartId2(Integer cart_id) throws FoodCartException;
}
