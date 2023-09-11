package com.nexturn.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nexturn.demo.Model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
	
//	List<Menu> findByDish_nameContainingIgnoreCase(String dish_name);

}
