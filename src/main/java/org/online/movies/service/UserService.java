package org.online.movies.service;

import org.online.movies.dto.UserDto;

public interface UserService {
    // Custom user service methods
    boolean isUserExist(String username);
    boolean isEmailExist(String email);

    UserDto save(UserDto userDto);

    boolean hasPermission(UserDto userDto, String create);
}
