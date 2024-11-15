package com.restservices.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
@GetMapping("/get/{UserId}")	
public String getUsers(@PathVariable String UserId ) {
	return "This is a Get Request:"+UserId;
}
@GetMapping("/details")
public String getUserDetails(@RequestParam String name, @RequestParam int age ) {
	return "The User name is:"+ name +" and age is:"+ age;
	
}

@PostMapping("/post")
public String postUser() {
	return "This is a Post Request which is used to update";
	
}

@PutMapping("/put")
public String putUser() {
	return "This is a Put Request which is used to add ";
}

@DeleteMapping("/delete")
public String deleteUser() {
	return "This is a Delete Request which is used to delete ";
	
}

}
