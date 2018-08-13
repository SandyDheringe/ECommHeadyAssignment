package com.heady.ecommerce.domain.productlist;

import dagger.Subcomponent;


/**
 * Created by SandeepD
 * on 15/05/18.
 * <p>
 * Custom scope for category screen, this is a child component of App Component
 * and needs to be smaller in size
 */
@ProductListScope
@Subcomponent(modules = {ProductListModule.class})
public interface ProductListComponent
{
    void inject(ProductListFragment productListFragment);
}