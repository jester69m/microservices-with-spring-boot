package com.reworked.user;

import com.reworked.dto.UserDto;
import com.reworked.model.user.User;
import com.reworked.payload.*;
import com.reworked.security.UserPrincipal;

import java.util.List;

public interface UserService {

	List<User> getAllUsers();
	UserDto getUserById(Long id);

	UserSummary getCurrentUser(UserPrincipal currentUser);

	UserIdentityAvailability checkUsernameAvailability(String username);

	UserIdentityAvailability checkEmailAvailability(String email);

	UserProfile getUserProfile(String username);

	User addUser(User user);

	User updateUser(User newUser, String username, UserPrincipal currentUser);

	ApiResponse deleteUser(String username, UserPrincipal currentUser);

	ApiResponse giveAdmin(String username);

	ApiResponse removeAdmin(String username);

	UserProfile setOrUpdateInfo(UserPrincipal currentUser, InfoRequest infoRequest);

}