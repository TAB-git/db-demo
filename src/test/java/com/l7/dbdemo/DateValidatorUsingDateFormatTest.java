package com.l7.dbdemo;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.l7.dbdemo.dto.parser.DateValidator;
import com.l7.dbdemo.dto.parser.L7DateAndFormatValidator;



//@SpringBootTest
public class DateValidatorUsingDateFormatTest {
	
	@Test
	public void testname() throws Exception {
		DateValidator validator = new L7DateAndFormatValidator("yyyyMMdd");

		assertTrue(validator.isValid("20190221"));
		assertTrue(validator.isValid("20211313"));
//		assertTrue(validator.isValid("02/30/2019"));
//		assertTrue(validator.isValid("12/32/2019"));
//		assertTrue(validator.isValid("00/28/2019"));
//		assertTrue(validator.isValid("02/00/2019"));
//		assertFalse(validator.isValid("02/01/0019"));
	}

}
