package com.nhatduy.Eshopper.serviceImpl;

import com.nhatduy.Eshopper.daoImpl.CategoryDaoImpl;
import com.nhatduy.Eshopper.dto.CategoriesDTO;
import com.nhatduy.Eshopper.entity.Categories;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.CategoryService;

import java.util.ArrayList;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Override
    public List<CategoriesDTO> getAllCategories() {
        CategoryDaoImpl categoryDao = new CategoryDaoImpl();
        List<CategoriesDTO> listCategoriesDTO = new ArrayList<>();
        List<Categories> listEntity = categoryDao.findAllPagination(new PageRequest(0, 0, new Sorter("categoryName", "asc")));
        for (Categories categories : listEntity) {
            CategoriesDTO categoriesDTO = new CategoriesDTO();
            categoriesDTO.setID(categories.getID());
            categoriesDTO.setCategoryName(categories.getCategoryName());
            categoriesDTO.setCreated_Date(categories.getCreated_Date());
            categoriesDTO.setModified_Date(categories.getModified_Date());
            listCategoriesDTO.add(categoriesDTO);
        }
        return listCategoriesDTO;
    }
}
