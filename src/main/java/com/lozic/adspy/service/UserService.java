package com.lozic.adspy.service;

import com.lozic.adspy.data.model.User;

public interface UserService {

    /**
     * Retrieves currently logged user.
     * 
     * @return currently logged {@link User}
     */
    User getLoggedUser();

}