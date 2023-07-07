package com.authorization.authorizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authorization.authorizationservice.entity.UserCredentials;

public interface UserCredentialRepository extends JpaRepository<UserCredentials, Integer>{
	Optional<UserCredentials> findByUsername(String username);
}
