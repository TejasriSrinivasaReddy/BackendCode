package com.ibm.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	UserRepository repo;
	void register(User user)
	{
		 repo.save(user);
	}
	
	void updateUser(User user) {
		repo.save(user);
	}
	
	void deleteUser(int userId) {
		repo.deleteById(userId);
	}
	
}
