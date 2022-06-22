package com.kaique.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kaique.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
