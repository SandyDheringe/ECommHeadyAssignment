package com.heady.ecommerce.domain.cartdetails;

import com.heady.ecommerce.api.ApiService;
import com.heady.ecommerce.dao.repo.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek
 * on 14/12/17.
 */

@Module
public class CartModule
{

    private final Contracts.View categoryView;

    public CartModule(Contracts.View categoryView)
    {
        this.categoryView = categoryView;
    }

    @Provides
    @CartScope
    CartPresenter provideCartPresenter(Repository repository)
    {
        return new CartPresenter(categoryView, repository);
    }
}
