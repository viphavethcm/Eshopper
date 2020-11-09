package com.nhatduy.Eshopper.serviceImpl;

import com.nhatduy.Eshopper.daoImpl.BrandDaoImpl;
import com.nhatduy.Eshopper.dto.BrandDTO;
import com.nhatduy.Eshopper.entity.Brand;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.BrandService;
import com.nhatduy.Eshopper.utils.BrandUtils;

import java.util.ArrayList;
import java.util.List;

public class BrandServiceImpl implements BrandService {

    public List<BrandDTO> getListBrand() {
        BrandDaoImpl brandDao = new BrandDaoImpl();
        List<Brand> listEntity = brandDao.findAllPagination(new PageRequest(0, 0, new Sorter("brandName", "asc")));
        List<BrandDTO> listBrandDTO = new ArrayList<>();
        for (Brand brand : listEntity) {
            listBrandDTO.add(BrandUtils.entity2DTO(brand));
        }
        return listBrandDTO;
    }

    public void addBrand(BrandDTO brandDTO) {

    }
}
