package org.online.movies.service;

import org.online.movies.dto.MovieDto;
import org.online.movies.dto.UserDto;
import org.online.movies.model.Movie;
import org.online.movies.model.User;
import org.online.movies.persistence.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isUserExist(String username) {
        return getUserByUsername(username) != null;
    }

    @Override
    public boolean isEmailExist(String email) {
        return false;
    }

    @Override
    public UserDto save(UserDto userDto) {

        if ( getUserByUsername(userDto.getUsername()) != null ) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = new UserDto();
        BeanUtils.copyProperties(savedUser, savedUserDto);

        return savedUserDto;
    }

    @Override
    public User getUserByUsername(String userName) {
        return userRepository.findByUsername(userName);
    }

}
