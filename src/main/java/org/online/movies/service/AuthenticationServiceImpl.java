package org.online.movies.service;

import org.online.movies.model.User;
import org.online.movies.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // Generate token and save it to the user object
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            userRepository.save(user);
            return user;
        }
        return null;
    }

    @Override
    public boolean hasSession(String username) {
        return false;
    }

    @Override
    public boolean isThereAnySession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if ( session == null ) {
            return false;
        }

        return session.getAttributeNames().hasMoreElements();
    }
}
