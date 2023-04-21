package org.online.movies.service;

import org.online.movies.dto.UserDto;
import org.online.movies.persistence.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public boolean isUserExist(String username) {
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public UserDto save(UserDto userDto) {
        return null;
    }

    @Override
    public boolean hasPermission(UserDto userDto, String create) {
        return false;
    }
}
