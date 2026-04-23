/**
 * @author jawc
 */
package br.com.jawc.dao.generic;

import br.com.jawc.dao.util.JPAUtil;
import jakarta.persistence.EntityManager;
import org.hibernate.mapping.PersistentClass;

import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDAO<T> implements IGenericDAO<T>{

    public GenericDAO() {
        this.em = JPAUtil.getEntityManager();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Class<T> persistentClass;
    protected EntityManager em;

    @Override
    public T save(T entity) {
       try{
           em.getTransaction().begin();
           em.persist(entity);
           em.getTransaction().commit();
           return entity;
       }catch (Exception e){
           if(em.getTransaction().isActive()){
               em.getTransaction().rollback();
           }
           throw e;
       }
    }

    @Override
    public T findById(Long id) {
            return em.find(persistentClass, id);
    }
    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public void delete(T entity) {

    }



    @Override
    public List findAll() {
        return List.of();
    }
}
