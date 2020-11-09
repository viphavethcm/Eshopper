package com.nhatduy.Eshopper.utils;

import com.nhatduy.Eshopper.dto.BrandDTO;
import com.nhatduy.Eshopper.entity.Brand;

public class BrandUtils {
    public static Brand DTO2entity(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setBrandID(brandDTO.getBrandID());
        brand.setBrandName(brandDTO.getBrandName());
        return brand;
    }

    public static BrandDTO entity2DTO(Brand brand) {
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setBrandID(brand.getBrandID());
        brandDTO.setBrandName(brand.getBrandName());
        return brandDTO;
    }
}
