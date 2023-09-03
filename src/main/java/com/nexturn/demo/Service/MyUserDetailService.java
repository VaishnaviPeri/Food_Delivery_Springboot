package com.nexturn.demo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.nexturn.demo.ExceptionHandling.UsernameNotFoundException;
import com.nexturn.demo.Model.User;
import com.nexturn.demo.Repository.UserRepository;

@Service
public class MyUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid user credentials");
		}
		SimpleGrantedAuthority sga = new SimpleGrantedAuthority(user.getRole());
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(sga);
		
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),list);
	}

//	@Override
//	public UserDetails loadUserByUsername(String username)
//			throws org.springframework.security.core.userdetails.UsernameNotFoundException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
