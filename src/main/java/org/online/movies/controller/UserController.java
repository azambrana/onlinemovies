package org.online.movies.controller;


import org.online.movies.dto.UserDto;
import org.online.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public UserDto register(UserDto userDto){
        UserDto savedDto = null;
        if ( userService.hasPermission(userDto, "CREATE") ) {
            savedDto = userService.save(userDto);
        }
        return savedDto;
    }
}
