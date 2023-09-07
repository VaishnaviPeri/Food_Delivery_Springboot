package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.DeliveryPartner;
import com.nexturn.demo.Model.User;


@Repository
public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, Integer>{
	
	@Query("select d from DeliveryPartner d where d.user.username=?1")
	DeliveryPartner findByUsername(String username);
	
	@Query("SELECT d from DeliveryPartner d where d.user.username=?1 ")
	DeliveryPartner findDeliveryPartnerDetails(String username);
	
	DeliveryPartner findByUser(User user);

}
