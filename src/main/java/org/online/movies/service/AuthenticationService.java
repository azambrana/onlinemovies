package org.online.movies.service;

import javax.servlet.http.HttpServletRequest;


public interface AuthenticationService {
    boolean authenticate(String username, String password);
    boolean hasSession(String username);
    boolean isThereAnySession(HttpServletRequest session);
}
