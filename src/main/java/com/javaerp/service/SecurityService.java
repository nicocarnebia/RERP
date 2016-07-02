package com.javaerp.service;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String username, String password);
}
