package com.epam.security.services;

import java.util.List;

import com.epam.security.models.AppUser;
import com.epam.security.models.Role;



public interface AppUserService {
	AppUser saveUser(AppUser user);
	Role saveRole(Role role);
	void addRoleToUser(String username, String role);
	AppUser getUser(String username);
	List<AppUser> getUsers();
}
