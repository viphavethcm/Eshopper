package com.nhatduy.Eshopper.dto;

import java.util.ArrayList;
import java.util.List;

public class AbstractDTO<T> {

    private Integer ID;
    private String create_Day;
    private String modify_Day;
    private List<T> listResult = new ArrayList<>();
    private Integer page;
    private Integer maxPageItem;
    private Integer totalPages;
    private Integer totalItems;
    private String sortName;
    private String sortBy;


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getCreate_Day() {
        return create_Day;
    }

    public void setCreate_Day(String create_Day) {
        this.create_Day = create_Day;
    }

    public String getModify_Day() {
        return modify_Day;
    }

    public void setModify_Day(String modify_Day) {
        this.modify_Day = modify_Day;
    }

    public List<T> getListResult() {
        return listResult;
    }

    public void setListResult(List<T> listResult) {
        this.listResult = listResult;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getMaxPageItem() {
        return maxPageItem;
    }

    public void setMaxPageItem(Integer maxPageItem) {
        this.maxPageItem = maxPageItem;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
