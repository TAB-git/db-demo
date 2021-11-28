package com.l7.dbdemo.dto;

import java.time.LocalDate;

import com.l7.dbdemo.validator.annotaion.CheckDateFormat;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String userName;
	private String email;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// implicit date auto correction works with @JsonFormat for ex : 2016-02-31
	// changes to 2016-02-29
	
	// No implicit date auto correction with out supporting annotation (@JsonFormat) - hence throws DateTimeParseException - nested InvalidFormatException
	//org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Cannot deserialize value of type `java.time.LocalDate` from String \"0016-00-18\": Failed to deserialize java.time.LocalDate: (java.time.format.DateTimeParseException) Text '0016-00-18' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 0; nested exception is com.fasterxml.jackson.databind.exc.InvalidFormatException: Cannot deserialize value of type `java.time.LocalDate` from String \"0016-00-18\": Failed to deserialize java.time.LocalDate: (java.time.format.DateTimeParseException) Text '0016-00-18' could not be parsed: Invalid value for MonthOfYear (valid values 1 - 12): 0\n at [Source: (PushbackInputStream); line: 4, column: 8] (through reference chain: com.l7.dbdemo.dto.UserDto[\"dob\"])\r\n\tat org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.readJavaType(AbstractJackson2HttpMessageConverter.java:389)\r\n\tat org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter.read(AbstractJackson2HttpMessageConverter.java:342)\r\n\tat org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodArgumentResolver.readWithMessageConverters(AbstractMessageConverterMethodAr
	@CheckDateFormat(pattern = "yyyy-MM-dd") // of use when mapping with a string date in dto
	private LocalDate dob;
}
