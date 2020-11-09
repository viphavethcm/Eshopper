package com.nhatduy.Eshopper.service;

import com.nhatduy.Eshopper.dto.BrandDTO;
import com.nhatduy.Eshopper.paging.logic.paging.Pageble;

import java.util.List;

public interface BrandService {
    List<BrandDTO> getListBrand();

    void addBrand(BrandDTO brandDTO);
}
