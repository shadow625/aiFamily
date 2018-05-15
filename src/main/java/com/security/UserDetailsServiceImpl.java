package com.security;

import com.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User.UserBuilder;
import com.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;

//to load user details
@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService
{
    @Autowired
    UserRepository userRepository;


    User user;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> iter=userRepository.findByUsername(username);
        if (iter.isPresent()){
            user=iter.get();
            return org.springframework.security.core.userdetails.User
                    .withUsername(user.getUsername())
                    .password(new BCryptPasswordEncoder().encode(user.getPassword()))
                    .roles("USER")
                    .build();

        }
        throw new UsernameNotFoundException(username+":this name not found");

    }
}
