package com.tekglobal.casestudyexample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tekglobal.casestudyexample.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {
	public User findUserByUsername(String username);
}

