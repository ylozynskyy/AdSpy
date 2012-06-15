package com.lozic.adspy.data.dao.impl;

import org.springframework.stereotype.Repository;

import com.lozic.adspy.data.dao.UserDao;
import com.lozic.adspy.data.model.User;

@Repository
public class UserJpaDao extends BaseJpaDao<User> implements UserDao {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
