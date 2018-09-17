package com.example.demo;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("".equals(username) || "".equals(password)) {
            throw new UsernameNotFoundException("Invalid credentials");
        }
        User user = userService.findByUsername(username);
        if (user==null) {
            throw new UsernameNotFoundException("Username invalid");
        }

        Boolean passwordsEqual = passwordEncoder.matches(password,user.getPassword());
        if (!passwordsEqual) {
            throw new UsernameNotFoundException("Password invalid");
        }

//        return new UsernamePasswordAuthenticationToken(user,password,user.getAuthorities());

        return new UsernamePasswordAuthenticationToken(user,password);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }

}
