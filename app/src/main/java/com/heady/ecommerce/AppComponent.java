package com.heady.ecommerce;

import com.heady.ecommerce.api.ApiModule;
import com.heady.ecommerce.domain.cartdetails.CartComponent;
import com.heady.ecommerce.domain.cartdetails.CartModule;
import com.heady.ecommerce.domain.categorylist.CategoryComponent;
import com.heady.ecommerce.domain.categorylist.CategoryModule;
import com.heady.ecommerce.domain.productdetails.ProductDetailComponent;
import com.heady.ecommerce.domain.productdetails.ProductDetailModule;
import com.heady.ecommerce.domain.productlist.ProductListComponent;
import com.heady.ecommerce.domain.productlist.ProductListModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * App component
 *
 * @author SandeepD
 */
@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent
{
    void inject(BaseApplication baseApplication);

    CategoryComponent newCategoryComponent(CategoryModule categoryModule);

    ProductListComponent newProductListComponent(ProductListModule categoryModule);

    ProductDetailComponent newProductDetailComponent(ProductDetailModule categoryModule);

    CartComponent newCartComponent(CartModule cartModule);
}