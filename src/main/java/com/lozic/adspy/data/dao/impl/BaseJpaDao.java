package com.lozic.adspy.data.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Base class for JPA DAO.
 * 
 * @author Yuriy_Lozynskyy
 * 
 * @param <T>
 *            entity class to be used by DAO
 */
public abstract class BaseJpaDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Implement this method in ancessors to indicate which entity instances are
     * used in DAO.
     *
     * <p/>
     * <code>
     * Example:
     * <p>
     * {@literal @}Entity 
     * public class Foo { ... }
     * <p>
     * public classFooJpaDaou extends BaseJpaDao<Foo> {<br>
     * &nbsp;protected Class<Foo> getEntityClass() {<br>
     * &nbsp;&nbsp; return Foo.class<br>
     * &nbsp;}<br>
     * }
     * </code>
     * 
     *  @return entity {@link Class}
     */
    protected abstract Class<T> getEntityClass();

    public T get(Object id) {
        return entityManager.find(getEntityClass(), id);
    }

}
