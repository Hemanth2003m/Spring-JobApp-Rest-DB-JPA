package com.hems.SpringBootRest.service;

import com.hems.SpringBootRest.model.User;
import com.hems.SpringBootRest.model.UserPrincipal;
import com.hems.SpringBootRest.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = repo.findByUsername(username);
        if(user == null){
            System.out.println("User 4o4");
            throw new UsernameNotFoundException("User 4o4");
        }

        return new UserPrincipal(user);
    }
}
