package com.example.libraryapi.api.exception;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.validation.BindingResult;

import com.example.libraryapi.exception.BusinessException;

public class ApiErrors {
	private List<String> errors;
	
	public ApiErrors(BindingResult bindResult) {
		this.errors = new ArrayList<>();
		bindResult.getAllErrors().forEach(error -> this.errors.add(error.getDefaultMessage()));
	}
	
	public ApiErrors(BusinessException ex) {
		this.errors = Arrays.asList(ex.getMessage());
	}	

	public List<String> getErrors(){
		return errors;
	}
}
