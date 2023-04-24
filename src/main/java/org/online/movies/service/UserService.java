package org.online.movies.service;

import org.online.movies.dto.UserDto;
import org.online.movies.model.User;

public interface UserService {
    // Custom user service methods
    boolean isUserExist(String username);
    boolean isEmailExist(String email);

    UserDto save(UserDto userDto);
    User getUserByUsername(String userName);
}
