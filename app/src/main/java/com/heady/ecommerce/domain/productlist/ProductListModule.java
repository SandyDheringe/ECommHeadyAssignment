package com.heady.ecommerce.domain.productlist;

import com.heady.ecommerce.api.ApiService;
import com.heady.ecommerce.dao.repo.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek
 * on 14/12/17.
 */

@Module
public class ProductListModule
{

    private final Contracts.View productListView;

    public ProductListModule(Contracts.View productListView)
    {
        this.productListView = productListView;
    }

    @Provides
    @ProductListScope
    ProductListPresenter provideProductListPresenter( Repository repository)
    {
        return new ProductListPresenter(productListView, repository);
    }
}
