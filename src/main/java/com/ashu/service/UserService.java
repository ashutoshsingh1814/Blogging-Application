package com.ashu.service;

import com.ashu.binding.LoginForm;
import com.ashu.binding.RegistrationForm;

public interface UserService {
	
	public boolean register(RegistrationForm form);
	
	public boolean login(LoginForm form);

}
