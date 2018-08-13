package com.heady.ecommerce.domain.productdetails;

import dagger.Subcomponent;


/**
 * Created by SandeepD
 * on 15/05/18.
 * <p>
 * Custom scope for category screen, this is a child component of App Component
 * and needs to be smaller in size
 */
@ProductDetailScope
@Subcomponent(modules = {ProductDetailModule.class})
public interface ProductDetailComponent
{
    void inject(ProductDetailFragment productDetailFragment);
}