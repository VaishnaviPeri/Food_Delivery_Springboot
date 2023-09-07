package com.nexturn.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.User;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

//	Optional<Customer> findByCustomer_name(String customer_name);
	
	@Query("select a from Customer a where a.user.username=?1")
	Customer findACustomerDetails(String username);
	
	Customer findByUser(User user);
	
//	@Query("select a.airlineCode from Customer a where a.user.username=?1")
//	String getACustomerCode(String username);
//	
//	@Query("select a from Customer a where a.user.id=?1")
//	Customer getCustomerByUserId(Long id);
	




}
