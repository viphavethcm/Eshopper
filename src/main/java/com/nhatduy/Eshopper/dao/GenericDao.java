package com.nhatduy.Eshopper.dao;

import com.nhatduy.Eshopper.paging.logic.paging.Pageble;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface GenericDao<ID extends Serializable, T> {
    int getTotalItems();// lấy tổng

    List<T> findAllPagination(Pageble pageble);// find List pagination

    T update(T entity);// update

    void save(T entity);// tạo mới

    T findById(ID id);// tìm theo ID

    Integer delete(List<ID> ids);// xóa theo ID

    Object[] findProperty(Map<String, Object> mapList, String sortExpression, String sortDirection);

    void test();
}
