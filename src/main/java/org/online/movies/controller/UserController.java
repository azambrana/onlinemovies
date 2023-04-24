package org.online.movies.controller;


import org.online.movies.dto.UserDto;
import org.online.movies.service.AuthenticationService;
import org.online.movies.service.AuthorizationService;
import org.online.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody UserDto userDto, HttpServletRequest request) {
        UserDto savedDto = null;
        if (authenticationService.isThereAnySession(request)) {
            return ResponseEntity.status(403).body(savedDto);
        }

        if ( userService.isUserExist(userDto.getUsername()) ) {
            return ResponseEntity.status(409).body(savedDto);
        }

        if ( authorizationService.hasPermission("anonymous", "CREATE", "USER") ) {
            savedDto = userService.save(userDto);
            return ResponseEntity.status(201).body(savedDto);
        }

        return ResponseEntity.status(403).body(savedDto);
    }
}
