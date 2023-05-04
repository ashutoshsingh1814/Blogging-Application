package com.ashu.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashu.binding.LoginForm;
import com.ashu.binding.RegistrationForm;
import com.ashu.entity.UserEntity;
import com.ashu.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public boolean register(RegistrationForm form) {
		
		
		UserEntity status = userRepo.findByEmail(form.getEmail());
		
		
		if(status != null) {
			return false;
		}
		else {
			UserEntity entity= new UserEntity();
			BeanUtils.copyProperties(form, entity);
			entity.setFirstName(form.getFirstName());
			entity.setLastName(form.getLastName());
			entity.setEmail(form.getEmail());
			entity.setPassword(form.getPassword());
			System.out.println(form);
			userRepo.save(entity);
			return true;
		}
		
		
	}
	
	@Override
	public boolean login(LoginForm form) {
		
		UserEntity user = userRepo.findByEmailAndPassword(form.getEmail(), form.getPassword());
		 if(user==null) {
			 return false;
		 }else {
			 return true;
		 }
		
	}
	

}
