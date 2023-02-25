package com.masai.team6.Services;

import java.util.List;

import com.masai.team6.Payloads.UserDto;

public interface UserService {

	UserDto registerNewUser(UserDto user);
	
	UserDto registerAdmin(UserDto user);

	UserDto createUser(UserDto user);

	UserDto updateUser(UserDto user, Integer userId);

	UserDto getUserById(Integer userId);

	List<UserDto> getAllUsers();

	void deleteUser(Integer userID);
	
	UserDto updatePassword(String email , String password);
	
	List<UserDto> getAdminUser();
	
	
//	String makeOtherUserAdmin(String email);

}
