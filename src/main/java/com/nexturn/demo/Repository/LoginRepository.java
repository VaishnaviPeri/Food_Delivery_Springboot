package com.nexturn.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexturn.demo.Model.User;


@Repository
public interface LoginRepository extends JpaRepository<User, String> {

}
