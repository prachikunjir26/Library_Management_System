package com.webtools.springproject.validator;

import com.webtools.springproject.pojo.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserFormValidator implements Validator {

	
	@Override
	public boolean supports(Class<?> clazz) {
	// TODO Auto-generated method stub
	return User.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
	// TODO Auto-generated method stub
	ValidationUtils.rejectIfEmpty(errors, "UserName","empty username" ,"username is empty");
	ValidationUtils.rejectIfEmpty(errors, "UserPass","empty userpass" ,"userpassword is empty");
	}

	
}
