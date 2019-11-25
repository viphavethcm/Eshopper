package com.nhatduy.core.data.daoimpl;

import com.nhatduy.core.common.utils.HibernateUtils;
import com.nhatduy.core.data.dao.GenericDao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class AbstractDao<ID extends Serializable,T> implements GenericDao<ID,T> {
    private Class<T> persistence;

    public AbstractDao() {
        this.persistence = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
}

    public List<T> findAll() {
        List<T> result = new ArrayList<T>();
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            StringBuilder SQL = new StringBuilder("from ");
            SQL.append(this.persistence);
            Query query = session.createQuery(SQL.toString());
            result = query.list();
            transaction.commit();
        }
        catch (Exception e){
            transaction.rollback();
            System.out.println("ERROR FIND ALL ......."+e.getMessage());
        }finally {
            session.close();
        }
        return result;
    }

    public void save(){

    }
}
