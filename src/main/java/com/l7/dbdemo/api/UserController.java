package com.l7.dbdemo.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.l7.dbdemo.dto.UserDto;
import com.l7.dbdemo.model.User;
import com.l7.dbdemo.model.Users;
import com.l7.dbdemo.repo.UserRepository;
import com.l7.dbdemo.repo.UsersRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UsersRepository usersRepository;
	@Autowired
	private UserRepository userRepository;

	@PostMapping
	private String adduser(@RequestBody UserDto userDto) {
		User user = new User();
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		user.setDob(userDto.getDob());
//		user.setDob(LocalDate.of(1993, 01, 01));
		user = userRepository.save(user);
		log.info("user is : {} ", user);

		Users users = new Users();
		users.setEmail(userDto.getEmail());
		users.setUserName(userDto.getUserName());
//		users.setDob(userDto.getDob());
		users.setDob(LocalDate.of(1993, 01, 01));
		usersRepository.save(users);
		log.info("users is : {} ", users);
		return "ok";
	}

	
	@PostMapping(path = "/test",consumes = MediaType.APPLICATION_JSON_VALUE,produces
			= MediaType.APPLICATION_JSON_VALUE)
	public void test(@RequestParam("date") String date) {
		log.info("date is :{}", date);
	}

	@PostMapping("/date")
	public void date(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		log.info("date is :{}", date);
	}

	@PostMapping("/local-date")
	public void localDate(
			@RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate localDate) {
		log.info("localDate is :{}", localDate);
	}

	@PostMapping("/local-date-time")
	public void dateTime(
			@RequestParam("localDateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime localDateTime) {
		log.info("localDateTime is :{}", localDateTime);
	}

//	@PostMapping("/date")
//	public void date1(@RequestParam("date") @DateTimeFormat(pattern = "dd.MM.yyyy") Date date) {
//		log.info("date is :{}", date);
//	}

}
