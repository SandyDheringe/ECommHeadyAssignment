package com.heady.ecommerce.model.roomentities.relation;

import android.arch.persistence.room.Embedded;

import com.heady.ecommerce.model.roomentities.Category;
import com.heady.ecommerce.model.roomentities.ParentChildCategoryMapping;

public class CategoryAndMapping
{
    @Embedded
    public Category category;

    @Embedded
    public ParentChildCategoryMapping parentChildCategoryMapping;

}
