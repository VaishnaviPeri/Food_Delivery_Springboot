package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Integer>{

}
