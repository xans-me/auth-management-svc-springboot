package com.xansme.authservice.service;

import com.xansme.authservice.domain.Role;
import com.xansme.authservice.domain.Users;

import java.util.List;

public interface UserService {
    Users saveUser(Users user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Users getUser(String username);
    List<Users> getUsers();
}
