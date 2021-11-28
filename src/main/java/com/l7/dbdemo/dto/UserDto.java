package com.l7.dbdemo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserDto {

	private Long id;
	private String userName;
	private String email;
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	// implicit date auto correction works with @JsonFormat for ex : 2016-02-31
	// changes to 2016-02-29
//	@CheckDateFormat(pattern = "yyyy-MM-dd")
	// No implicit date auto correction with out supporting annotation (@JsonFormat) - hence throws DateTimeParseException - nested InvalidFormatException
	private LocalDate dob;
}
