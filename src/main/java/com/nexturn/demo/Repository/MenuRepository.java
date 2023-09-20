package com.nexturn.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.ExceptionHandling.MenuException;
import com.nexturn.demo.Model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
	@Query("select m from Menu m where m.dish_name=?1")
    List<Menu> findByDishName(String dish_name) throws MenuException;
	
	@Modifying
	@Query("DELETE FROM Menu m WHERE m.dish_name = :dish_name")
	void deleteByDishName(@Param("dish_name") String dish_name);


}
