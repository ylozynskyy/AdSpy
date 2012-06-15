package com.lozic.adspy.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lozic.adspy.data.dao.UserDao;

public class DaoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.lozic.adspy.data.model.User user = userDao.findByUsername(username);
        return new User(user.getUsername(), user.getPassword(), true, true, true, true, user.getRoles());
    }

}
