package org.online.movies.controller;


import org.online.movies.dto.UserDto;
import org.online.movies.model.User;
import org.online.movies.service.AuthenticationService;
import org.online.movies.service.AuthorizationService;
import org.online.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.Charset;
import java.util.Base64;

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

        if ( authorizationService.hasPermission("anonymous", "CREATE_USER", "USER") ) {
            savedDto = userService.save(userDto);
            return ResponseEntity.status(201).body(savedDto);
        }

        return ResponseEntity.status(403).body(savedDto);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestHeader("Authorization") String authorization) {
        // Extract username and password from Authorization header
        String base64Credentials = authorization.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
        String[] usernameAndPassword = credentials.split(":");
        String username = usernameAndPassword[0];
        String password = usernameAndPassword[1];

        // Authenticate user
        User user = authenticationService.authenticate(username, password);
        if (user != null) {
            // Return token
            return ResponseEntity.ok().body(user.getToken());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
