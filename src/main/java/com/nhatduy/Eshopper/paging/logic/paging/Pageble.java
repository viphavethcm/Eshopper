package com.nhatduy.Eshopper.paging.logic.paging;

import com.nhatduy.Eshopper.paging.logic.sort.Sorter;

public interface Pageble {
    Integer getPage();

    Integer getOffset();

    Integer getLimit();

    Sorter getSorter();
}
