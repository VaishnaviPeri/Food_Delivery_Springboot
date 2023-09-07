package com.nexturn.demo.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.ExceptionHandling.UsernameNotFoundException;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
//	@Query("SELECT u FROM User u WHERE u.username = ?1")
//	Optional<Customer> findByCustomerName(@Param("customer_name") String customer_name);
//	User findByUsername(String username) ;
//	
//	User findByUsernameAndPassword(String username, String password);
	
	@Query("select u from User u where u.username=?1")
	User findByUsername(String username);

	@Query("select u from User u where u.id=?1")
	User getUserByuserId(Long id);

}
