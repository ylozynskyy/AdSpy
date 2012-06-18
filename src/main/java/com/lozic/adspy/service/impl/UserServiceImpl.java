package com.lozic.adspy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.lozic.adspy.data.dao.UserDao;
import com.lozic.adspy.data.model.User;
import com.lozic.adspy.service.UserService;

/**
 * {@link UserService} and {@link UserDetailsService} implementation.
 * 
 * @author Yuriy_Lozynskyy
 * 
 */
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByUsername(username);
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), true,
                true, true, true, user.getRoles());
    }

    @Override
    public User getLoggedUser() {
        return userDao.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
    }

}
