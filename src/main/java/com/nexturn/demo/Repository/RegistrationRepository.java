package com.nexturn.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.RegisterModel;


@Repository
public interface RegistrationRepository extends JpaRepository<RegisterModel, Integer> {
	
}
