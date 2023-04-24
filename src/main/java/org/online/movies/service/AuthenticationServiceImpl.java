package org.online.movies.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public boolean authenticate(String username, String password) {
        return false;
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
