package org.online.movies.service;

import org.online.movies.model.User;

import javax.servlet.http.HttpServletRequest;


public interface AuthenticationService {
    User authenticate(String username, String password);
    boolean hasSession(String username);
    boolean isThereAnySession(HttpServletRequest session);
}
