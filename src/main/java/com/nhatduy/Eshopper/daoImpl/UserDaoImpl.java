package com.nhatduy.Eshopper.daoImpl;

import com.nhatduy.Eshopper.common.utils.HibernateUtils;
import com.nhatduy.Eshopper.dao.UserDao;
import com.nhatduy.Eshopper.entity.Role;
import com.nhatduy.Eshopper.entity.User;
import com.nhatduy.Eshopper.utils.UserUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    public User check(String userName, String passWord) {
        String b;
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User result = null;
        try {
            StringBuilder SQL = new StringBuilder(" FROM " + User.class.getSimpleName());
            SQL.append(" WHERE userName = :name AND passWord = :password");
            Query query = session.createQuery(SQL.toString());
            query.setParameter("name", userName);
            query.setParameter("password", UserUtils.getMD5(passWord));
            transaction.commit();
            result = (User) query.uniqueResult();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR CHECK..." + e.getMessage());
        } finally {
            session.close();
        }

        return result;
    }

    @Override
    public List<String> getRole(int userID) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<String> roles = null;
        try {
            StringBuilder SQL = new StringBuilder("select roleName from role,user_role");
            SQL.append(" where role.roleID = user_role.roleID and userID=" + userID);
            Query query = session.createSQLQuery(SQL.toString());
            roles = query.getResultList();
        } catch (Exception e) {
            transaction.rollback();
            ;
            System.out.println("ERROR FIND..." + e.getMessage());
        } finally {
            session.close();
        }
        return roles;
    }


}
