package com.javaerp.service;

import com.javaerp.model.Role;
import com.javaerp.model.User;
import com.javaerp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.LoggerFactory;

public class UserDetailsServiceImpl implements UserDetailsService {

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);
    @Autowired
    private UserRepository userRepository;
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        logger.info(user.getRole().getName());
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
        
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
    }
}
