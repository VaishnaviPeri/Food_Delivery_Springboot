package com.nexturn.demo.Security;

//import java.beans.Customizer;
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import com.nexturn.demo.Model.Customer;
import com.nexturn.demo.Service.CustomerService;
import com.nexturn.demo.Service.MyUserDetailService;

@Configuration
@EnableWebSecurity
public class JWTConfig {
	@Autowired
	private MyUserDetailService myUserDetailService;
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((authorise) -> {
			try {
				authorise.requestMatchers("/user/login").permitAll()
						 .requestMatchers("/user/get/details").authenticated()
				.anyRequest()
				 .permitAll()
				 .and()
				 .csrf().disable();

			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

		})
		.httpBasic(Customizer.withDefaults());
		http.authenticationProvider(getDBAuth());
		return http.build();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider getDBAuth() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
		dao.setPasswordEncoder(getPasswordEncoder());
		dao.setUserDetailsService(myUserDetailService);
		return dao;
	}
}


//@Value("${jwt.secret}")
//private String secret;
//
//@Value("${jwt.expiration}")
//private long expiration;
//
//public String generateToken(String username) {
//    return Jwts.builder()
//            .setSubject(username)
//            .setIssuedAt(new Date())
//            .setExpiration(new Date(System.currentTimeMillis() + expiration))
//            .signWith(SignatureAlgorithm.HS256, secret)
//            .compact();
//}
//
//public String extractUsername(String token) {
//    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
//}

