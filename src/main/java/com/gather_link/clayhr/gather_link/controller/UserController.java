package com.gather_link.clayhr.gather_link.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gather_link.clayhr.gather_link.exceptions.UserNotFoundException;
import com.gather_link.clayhr.gather_link.exceptions.UserResponse;
import com.gather_link.clayhr.gather_link.model.Users;
import com.gather_link.clayhr.gather_link.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody Users user) {
    	Map<String, Object> response = new HashMap<>();    	
    	logger.info("createUser(): begin");
    	
    	try {
    		
    		userService.create(user);
    		
    		response.put("userResponse", new UserResponse(true, "User created successfully"));
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    		
    	} catch (Exception e) {
    		
    		logger.error("Error while creating user", e);
    		
    		response.put("userResponse", new UserResponse(false, "Internal server error"));
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    	}
        
    }
    
    @GetMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable("user_id") Long user_id) {
    	Map<String, Object> response = new HashMap<>();
    	logger.info("getUser(): begin");
    	
    	try {
    		
    		Users user = userService.getByUserId(user_id);
    		
    		response.put("user", user);
    		response.put("userResponse", new UserResponse(true, "User found successfully"));
    		
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    		
    	} catch (UserNotFoundException e) {
    		
    		logger.error("User not found by id: {}", user_id, e);
    		
    		response.put("userResponse", new UserResponse(false, "User not found"));
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    		
    	} catch (Exception e) {
    		
            logger.error("Error while retreiving user by id", e);
            
            response.put("userResponse", new UserResponse(false, "Internal server error"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            
        }
    }
    
    @DeleteMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> deleteUser(@PathVariable("user_id") Long user_id) {
    	Map<String, Object> response = new HashMap<>();
    	logger.info("deleteUser(): begin");
    	
    	try {
    		
    		userService.deleteUser(user_id);
    		
    		response.put("userResponse", new UserResponse(true, "User deleted successfully"));
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    		
    	} catch (UserNotFoundException e) {
    		
    		logger.error("User not found by id for delete: {}", user_id, e);
    		
    		response.put("userResponse", new UserResponse(false, "User not found"));
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    		
    	} catch (Exception e) {
    		
    		logger.error("Error while deleting user", e);
    		
    		response.put("userResponse", new UserResponse(false, "Internal server error"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            
    	}
    }
    
    @PutMapping("/{user_id}")
    public ResponseEntity<Map<String, Object>> updateUser(@PathVariable("user_id") Long user_id, @RequestBody Users user) {
    	Map<String, Object> response = new HashMap<>();
    	logger.info("updateUser(): begin");
    	
    	try {
    		user.setUserId(user_id);
            userService.updateUser(user);
            
            response.put("userResponse", new UserResponse(true, "User updated successfully"));
            return ResponseEntity.status(HttpStatus.OK).body(response);
            
    	} catch (UserNotFoundException e) {
    		
    		logger.error("User not found by id for update: {}", user_id, e);
    		
    		response.put("userResponse", new UserResponse(false, "User not found"));
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    		
    	} catch (Exception e) {
    		
    		logger.error("Error while updating user", e);
    		
    		response.put("userResponse", new UserResponse(false, "Internal server error"));
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    		
    	}
    	
    }
    
    @GetMapping("/by-username")
    public ResponseEntity<Map<String, Object>> getByUsername(@RequestParam(name = "username") String username) {
    	Map<String, Object> response = new HashMap<>();
    	logger.info("getbyUsername(): begin");
    	
    	try {
    		
    		Users user = userService.getUserByUsername(username);
    		
    		response.put("user", user);
    		response.put("userResponse", new UserResponse(true, "User found by username"));
    		
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    		
    	} catch (Exception e) {
    		
    		logger.error("Error while retreiving user by username", e);
    		
    		response.put("userResponse", new UserResponse(false, "Internal server error"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    		
    	}
    	
    }
    
    @GetMapping("/by-email")
    public ResponseEntity<Map<String, Object>> getByEmail(@RequestParam(name = "email") String email) {
    	Map<String, Object> response = new HashMap<>();
    	logger.info("getbyEmail(): begin");
    	
    	try {
    		
    		Users user = userService.getUserByEmail(email);
    		
            response.put("user", user);
            response.put("userResponse", new UserResponse(true, "User found by email"));
            
            return ResponseEntity.status(HttpStatus.OK).body(response);
            
    	} catch (Exception e) {
    		
    		logger.error("Error while retreiving user by email", e);
    		
    		response.put("userResponse", new UserResponse(false, "Internal server error"));
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    		
    	}
    }

}