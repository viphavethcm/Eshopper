package com.nhatduy.Eshopper.daoImpl;

import com.nhatduy.Eshopper.common.utils.HibernateUtils;
import com.nhatduy.Eshopper.dao.GenericDao;
import com.nhatduy.Eshopper.entity.Attribute;
import com.nhatduy.Eshopper.entity.Categories;
import com.nhatduy.Eshopper.entity.Product;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private Class<T> persistence;

    public AbstractDao() {
        this.persistence = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Override
    public int getTotalItems() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        int count = 0;
        try {
            StringBuilder SQL = new StringBuilder("select count (*) from ");
            SQL.append(persistence.getSimpleName());
            Query query = session.createQuery(SQL.toString());
            Object object = query.getSingleResult();
            count = Integer.parseInt(object.toString());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR COUNT ......." + e.getMessage());
        } finally {
            session.close();
        }
        return count;
    }

    public List<T> findAllPagination(Pageble pageble) {
        List<T> result = new ArrayList<T>();
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder SQL = new StringBuilder("FROM " + persistence.getSimpleName());
            if (persistence.getSimpleName().equalsIgnoreCase("Product")) {
                SQL.append(" WHERE active = true");
            }
            if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName()) && StringUtils.isNotBlank(pageble.getSorter().getSortBy())) {
                SQL.append(" ORDER BY " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
            }
            Query query = session.createQuery(SQL.toString());
            if (pageble.getOffset() != null && pageble.getLimit() != null) {
                query.setFirstResult(pageble.getOffset());
                query.setMaxResults(pageble.getLimit());
            }
            result = query.getResultList();
            if (persistence.getSimpleName().equalsIgnoreCase("Product")) {
                for (Product product : (List<Product>) result) {
                    Hibernate.initialize(product.getProductAttributeValues());
                }
            } else if (persistence.getSimpleName().equalsIgnoreCase("Attribute")) {
                for (Attribute attribute : (List<Attribute>) result) {
                    Hibernate.initialize(attribute.getAttributeValues());
                }
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR FIND ALL ......." + e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    public T update(T entity) {
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            Object object = session.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR UPDATE ..." + e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    public void save(T entity) {
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(entity);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR SAVE ..." + e.getMessage());
        } finally {
            session.close();
        }
    }


    public T findById(ID id) {
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        T result = null;
        try {
            Object object = session.get(persistence, id);
            result = (T) object;
            if (result == null) {
                throw new ObjectNotFoundException("NOT FOUND " + id, null);
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR FINDBYID..." + e.getMessage());
        } finally {
            session.close();
        }
        return result;
    }

    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (ID id : ids) {
                T entity = (T) session.get(persistence, id);
                session.delete(entity);
                count++;
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR DELETE..." + e.getMessage());
        } finally {
            session.close();
        }
        return count;
    }

    public Object[] findProperty(Map<String, Object> mapList, String sortExpression, String sortDirection) {
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<T> listEntity = null;
        String[] paramater = new String[mapList.size()];
        Object[] value = new Object[mapList.size()];
        int i = 0;
        try {
            if (mapList != null) {
                for (Map.Entry<String, Object> item : mapList.entrySet()) {
                    paramater[i] = item.getKey();
                    value[i] = item.getValue();
                    i++;
                }
            }
            StringBuilder sql = new StringBuilder("from ").append("where 1=1 ");
            if (mapList != null) {
                for (int i1 = 0; i1 < mapList.size(); i1++) {
                    sql.append("and " + paramater[i] + "=:" + paramater[i]);
                }
            }
            Query query = session.createQuery(sql.toString());
            if (mapList != null) {
                for (int i2 = 0; i2 < mapList.size(); i2++) {
                    query.setParameter(paramater[i], value[i]);
                }
            }
            listEntity = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR SEARCH..." + e.getMessage());
        } finally {
            session.close();
        }
        return new Object[]{listEntity, listEntity.size()};
    }

    @Override
    public void test() {

    }

}