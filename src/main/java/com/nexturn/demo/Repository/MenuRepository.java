package com.nexturn.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.nexturn.demo.Model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	

	
	@Modifying
	@Query("DELETE FROM Menu m WHERE m.dish_name = :dish_name")
	void deleteByDishName(@Param("dish_name") String dish_name);


}
