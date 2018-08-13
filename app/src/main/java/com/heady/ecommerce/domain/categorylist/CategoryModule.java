package com.heady.ecommerce.domain.categorylist;

import com.heady.ecommerce.api.ApiService;
import com.heady.ecommerce.dao.repo.Repository;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek
 * on 14/12/17.
 */

@Module
public class CategoryModule
{

    private final Contracts.View categoryView;

    public CategoryModule(Contracts.View categoryView)
    {
        this.categoryView = categoryView;
    }

    @Provides
    @CategoryScope
    CategoryListPresenter provideCategoryListPresenter(ApiService apiService, Repository repository)
    {
        return new CategoryListPresenter(categoryView, apiService,repository);
    }
}
