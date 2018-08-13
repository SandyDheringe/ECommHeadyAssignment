package com.heady.ecommerce.domain.categorylist;

import com.heady.ecommerce.domain.productlist.ProductListFragment;

import dagger.Subcomponent;


/**
 * Created by SandeepD
 * Custom scope for category screen, this is a child component of App Component
 * and needs to be smaller in size
 */
@CategoryScope
@Subcomponent(modules = {CategoryModule.class})
public interface CategoryComponent
{
    void inject(CategoryListFragment categoryListFragment);
    void inject(SubCategoryListFragment subCategoryListFragment);

}