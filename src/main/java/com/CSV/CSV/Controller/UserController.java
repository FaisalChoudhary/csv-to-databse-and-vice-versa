package com.CSV.CSV.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CSV.CSV.Service.UserService;

@RestController
public class UserController {


	@Autowired
	UserService userService;

	@GetMapping("/transfer/data")
	public String transferData() throws IOException {
		userService.readDataFromFile();
		return "Data inserted to database";
	}


	@GetMapping("/dbtocsv")
	public 	String file() {
		userService.file();
		return "File created";
	}
}
