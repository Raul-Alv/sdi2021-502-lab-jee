package com.uniovi.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.uniovi.entities.Professor;
import com.uniovi.entities.User;
import com.uniovi.services.ProfessorService;
import com.uniovi.services.UsersService;

@Component
public class AddProfessorValidator implements Validator{

	@Autowired
	private ProfessorService professorService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Professor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Professor user = (Professor) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dni", "Error.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "Error.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "apellidos", "Error.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categoria", "Error.empty");
		
		if (user.getDni().length() != 9) {
			errors.rejectValue("dni", "Error.signup.dni.length");
		}
		
		char c = (Character)user.getDni().charAt(user.getDni().length() - 1);
		if(!Character.isLetter(c)) {
			errors.rejectValue("dni", "Error.notLetter");
		}	
	}

	
}
