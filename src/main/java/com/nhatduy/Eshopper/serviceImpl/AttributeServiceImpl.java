package com.nhatduy.Eshopper.serviceImpl;

import com.nhatduy.Eshopper.daoImpl.AttributeDaoImpl;
import com.nhatduy.Eshopper.dto.AttributeDTO;
import com.nhatduy.Eshopper.dto.AttributeValuesDTO;
import com.nhatduy.Eshopper.entity.Attribute;
import com.nhatduy.Eshopper.entity.AttributeValues;
import com.nhatduy.Eshopper.paging.logic.paging.PageRequest;
import com.nhatduy.Eshopper.paging.logic.sort.Sorter;
import com.nhatduy.Eshopper.service.AttributeService;

import java.util.ArrayList;
import java.util.List;

public class AttributeServiceImpl implements AttributeService {

    @Override
    public List<AttributeDTO> getListAttribute() {
        AttributeDaoImpl attributeDao = new AttributeDaoImpl();
        List<AttributeDTO> listAttributeDTO = new ArrayList<>();
        List<Attribute> listEntity = attributeDao.findAllPagination(new PageRequest(0, 0, new Sorter("attributeName", "asc")));
        for (Attribute attribute : listEntity) {
            List<AttributeValuesDTO> listAttributeValueDTO = new ArrayList<>();
            AttributeDTO attributeDTO = new AttributeDTO();
            attributeDTO.setID(attribute.getAttributeID());
            attributeDTO.setAttributeName(attribute.getAttributeName());
            for (AttributeValues attributeValues : attribute.getAttributeValues()) {
                AttributeValuesDTO attributeValuesDTO = new AttributeValuesDTO();
                attributeValuesDTO.setAttributeValueID(attributeValues.getAttributeValueID());
                attributeValuesDTO.setValueName(attributeValues.getValueName());
                listAttributeValueDTO.add(attributeValuesDTO);
            }
            attributeDTO.setAttributeValues(listAttributeValueDTO);
            listAttributeDTO.add(attributeDTO);
        }
        return listAttributeDTO;
    }
}
