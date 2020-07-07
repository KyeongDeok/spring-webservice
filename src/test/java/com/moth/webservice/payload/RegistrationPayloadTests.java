package com.moth.webservice.payload;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

public class RegistrationPayloadTests {
	private Validator validator;
	
	@Before
	public void setup () {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void validate_blankPayload_shouldFail() {
		
		RegistrationPayload payload = new RegistrationPayload();
		Set<ConstraintViolation<RegistrationPayload>> violations = validator.validate(payload);
		assertEquals(3, violations.size());
		
	}
}
