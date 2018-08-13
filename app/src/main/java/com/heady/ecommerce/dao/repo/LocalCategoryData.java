package com.heady.ecommerce.dao.repo;

import com.heady.ecommerce.database.AppDatabase;
import com.heady.ecommerce.model.roomentities.Category;
import com.heady.ecommerce.model.roomentities.relation.CategoryAndMappingNew;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class LocalCategoryData implements DataSource<Category>
{

    AppDatabase appDatabase;

    @Inject
    public LocalCategoryData(AppDatabase appDatabase)
    {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(Category category)
    {
        appDatabase.categoryDataDao().insert(category);
    }

    @Override
    public void addItems(List<Category> items)
    {
        appDatabase.categoryDataDao().insertAll(items);
    }

    public Single<List<Category>> getCategories()
    {
        return appDatabase.categoryDataDao().getCategories();
    }

    public Single<List<Category>> getParentCategories()
    {
        return appDatabase.categoryDataDao().getParentCategories();
    }

    public Single<List<Category>> getChildCategories(int categoryId)
    {
        return appDatabase.categoryDataDao().getChildCategories(categoryId);
    }

    public Single<List<Category>> getParentSubCategoriesByParentCategoryId(int parentCategoryId)
    {
        return appDatabase.categoryDataDao().getParentSubCategoriesByParentCategoryId(parentCategoryId);
    }

    public Single<List<CategoryAndMappingNew>> getChildSubCategoriesByParentCategoryId(int parentCategoryId)
    {
        return appDatabase.categoryDataDao().getChildSubCategoriesByParentCategoryId(parentCategoryId);
    }

}
