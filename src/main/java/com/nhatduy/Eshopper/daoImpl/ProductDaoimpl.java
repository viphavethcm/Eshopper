package com.nhatduy.Eshopper.daoImpl;

import com.nhatduy.Eshopper.common.utils.HibernateUtils;
import com.nhatduy.Eshopper.dao.ProductDao;
import com.nhatduy.Eshopper.entity.Categories;
import com.nhatduy.Eshopper.entity.Product;
import com.nhatduy.Eshopper.entity.ProductImage;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoimpl extends AbstractDao<Integer, Product> implements ProductDao {


    public void updateImage(ProductImage productImage) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(productImage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR SAVE ..." + e.getMessage());
        } finally {
            session.close();
        }
    }

    @Override
    public List<Product> getListSimpleProduct(int productID) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder("SELECT p FROM LinkedProducts link JOIN link.LinkedProduct p" +
                    " WHERE link.productID = :productID");
            Query query = session.createQuery(SQL.toString());
            query.setParameter("productID", productID);
            products = query.getResultList();
            for (Product product : products) {
                Hibernate.initialize(product.getProductAttributeValues());
            }
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR SAVE ..." + e.getMessage());
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public Product getProductDetails(String productName) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Product product = null;
        try {
            //JOIN FETCH p.productAttributeValues
            StringBuilder SQL = new StringBuilder("FROM Product p");
            SQL.append(" WHERE p.productName = :productName AND p.active = true ");
            Query query = session.createQuery(SQL.toString());
            query.setParameter("productName", productName);
            product = (Product) query.getSingleResult();
            Hibernate.initialize(product.getProductAttributeValues());
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR SAVE ..." + e.getMessage());
        } finally {
            session.close();
        }
        return product;
    }


    @Override
    public List<Product> getListProductActive() {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> products = new ArrayList<>();
        try {
            StringBuilder SQL = new StringBuilder("FROM Product p");
            SQL.append(" WHERE p.active = true ");
            Query query = session.createQuery(SQL.toString());
            products = query.getResultList();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR FIND..." + e.getMessage());
        } finally {
            session.close();
        }
        return products;
    }

    @Override
    public void addProduct(List<Product> products) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            for (Product product : products) {
                session.save(product);
                transaction.commit();
            }
        } catch (Exception e) {
            transaction.rollback();
            System.out.println("ERROR ADD..." + e.getMessage());
        } finally {
            session.close();
        }
    }

}
