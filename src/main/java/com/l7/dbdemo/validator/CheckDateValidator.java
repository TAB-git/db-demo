package com.l7.dbdemo.validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.google.common.base.Strings;
import com.l7.dbdemo.validator.annotaion.CheckDateFormat;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {
	private Boolean isOptional;
	private String pattern;

	@Override
	public void initialize(CheckDateFormat validDate) {
		this.isOptional = validDate.optional();
		this.pattern = validDate.pattern();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		boolean validDate = isValidFormat(this.pattern, value);
		return Boolean.TRUE.equals(isOptional) ? (validDate || (Strings.isNullOrEmpty(value))) : validDate;
	}

	static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
//			DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern(format);
//			TemporalAccessor parse = dateTimeFormatter.parse(format);
//			LocalDate parse2 = LocalDate.parse(value, dateTimeFormatter);
			if (value != null) {
				date = sdf.parse(value);
				if (!value.equals(sdf.format(date))) {
					date = null;
				}
			}
		} catch (ParseException ex) {
			log.error(ex.toString());
		}
		return date != null;
	}
}
