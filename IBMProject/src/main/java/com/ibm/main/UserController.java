package com.ibm.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	@Autowired
	UserService service;
	
	@Autowired
	UserRepository repo;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register/users")
	void register(@RequestBody User user) {
		//User user1=repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
				service.register(user);
	}
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	void updateUser(@RequestBody User user) {
		service.updateUser(user);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
	void deleteUser(@PathVariable int id) {
		service.deleteUser(id);
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/login/{email}/{password}")
	public String login(@PathVariable String email,@PathVariable String password)
	{
		User user=repo.findByEmail(email);
		if(!user.getPassword().equals(password))
		{
			System.out.println("invalid username and password");
			return "failed";
		}
		else
		{
			System.out.println("Successfully logged in");
			return "success";
		}
	}
}
