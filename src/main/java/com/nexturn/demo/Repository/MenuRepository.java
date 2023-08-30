package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.nexturn.demo.Model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

}
