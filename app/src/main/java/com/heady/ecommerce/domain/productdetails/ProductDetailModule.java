package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.api.ApiService;
import com.heady.ecommerce.dao.repo.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Product detail module
 *
 * @author SandeepD
 */
@Module
public class ProductDetailModule
{

    private final Contracts.View productListView;

    public ProductDetailModule(Contracts.View productListView)
    {
        this.productListView = productListView;
    }

    @Provides
    @ProductDetailScope
    ProductDetailPresenter provideProductDetailPresenter(Repository repository)
    {
        return new ProductDetailPresenter(productListView, repository);
    }
}
