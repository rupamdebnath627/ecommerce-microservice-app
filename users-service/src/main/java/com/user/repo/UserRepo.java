package com.user.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.Users;

public interface UserRepo extends JpaRepository<Users, Long> {

}
