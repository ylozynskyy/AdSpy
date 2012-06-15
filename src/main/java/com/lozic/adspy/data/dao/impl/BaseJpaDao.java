package com.lozic.adspy.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseJpaDao<T> {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	protected abstract Class<T> getEntityClass();
	
	public T get(Object id) {
		return entityManager.find(getEntityClass(), id);
	}

}
