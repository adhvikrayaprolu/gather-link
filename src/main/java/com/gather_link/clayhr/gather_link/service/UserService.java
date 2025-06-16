package com.gather_link.clayhr.gather_link.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gather_link.clayhr.gather_link.exceptions.UserNotFoundException;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;

    public void create(Users user) {
        userRepository.save(user);
    }

	public void deleteUser(Long user_id) throws UserNotFoundException {
		userRepository.deleteById(user_id);
	}

	public void updateUser(Users user) throws UserNotFoundException {
		userRepository.save(user);
	}
	
	public List<Users> getAllUsers() {
		return userRepository.findAll();
	}
	
	public Users getByUserId(Long user_id) throws UserNotFoundException {
		Optional<Users> user = userRepository.findById(user_id);
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found by ID");
		}
		return user.get();
	}
	
	public Users getUserByUsername(String username) {
	    return userRepository.findByUsername(username);
	}

	public Users getUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
}