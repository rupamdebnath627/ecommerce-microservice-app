package com.authorization.authorizationservice.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.authorization.authorizationservice.entity.UserCredentials;
import com.authorization.authorizationservice.repository.UserCredentialRepository;

public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserCredentialRepository userCredentialRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserCredentials> credential = userCredentialRepository.findByUsername(username);
        return credential.map(CustomUserDetails::new).orElseThrow(() -> new UsernameNotFoundException("user not found with name :" + username));
	}

}
