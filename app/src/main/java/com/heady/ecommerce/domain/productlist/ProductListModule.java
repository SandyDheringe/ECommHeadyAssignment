package com.heady.ecommerce.domain.productlist;

import com.heady.ecommerce.api.ApiService;
import com.heady.ecommerce.dao.repo.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Product list module
 *
 * @author SandeepD
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
