package com.example.demo.service;

import java.security.Key;
import java.util.Date;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

   
	public String createUser(User user) {
		if (userRepository.findByName(user.getName()).isPresent()) {
			throw new IllegalArgumentException("Username already exists: " + user.getName());
		}

		BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		User savedUser = userRepository.save(user);
		user.setPassword(encodedPassword);
		String token = generateJWTToken(savedUser.getId());
		savedUser.setJwtToken(token);
		userRepository.save(savedUser);

		return token;
	}

	public User getUserByEmail(String email) {
		Optional<User> optionalUser = userRepository.findByEmail(email);
		return optionalUser.orElse(null); // Return null if user is not found
	}
	// Implement other CRUD operations

	private String generateJWTToken(int userId) {
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
		long expirationTimeInMillis = 864000000; // 10 days in milliseconds

		Date now = new Date();
		Date expiryDate = new Date(now.getTime() + expirationTimeInMillis);

		return Jwts.builder().setSubject(String.valueOf(userId)).setIssuedAt(now).setExpiration(expiryDate)
				.signWith(key).compact();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

		return org.springframework.security.core.userdetails.User.builder().username(user.getName())
				.password(user.getPassword()).build();
	}
}