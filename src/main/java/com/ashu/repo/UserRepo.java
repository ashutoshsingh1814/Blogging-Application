package com.ashu.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashu.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity  findByEmail(String email);
	public UserEntity findByEmailAndPassword(String email, String password);

}
