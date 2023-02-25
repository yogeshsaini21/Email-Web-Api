package com.masai.team6.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.team6.Entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);
}
