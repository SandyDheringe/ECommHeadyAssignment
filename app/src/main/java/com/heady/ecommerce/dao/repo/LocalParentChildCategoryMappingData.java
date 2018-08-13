package com.heady.ecommerce.dao.repo;

import com.heady.ecommerce.database.AppDatabase;
import com.heady.ecommerce.model.roomentities.ParentChildCategoryMapping;

import java.util.List;

import javax.inject.Inject;

/**
 * local data source.
 * @author SandeepD
 */
public class LocalParentChildCategoryMappingData implements DataSource<ParentChildCategoryMapping>
{

    AppDatabase appDatabase;

    @Inject
    public LocalParentChildCategoryMappingData(AppDatabase appDatabase)
    {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(ParentChildCategoryMapping parentChildCategoryMapping)
    {
        appDatabase.parentChildCategoryMappingDataDao().insert(parentChildCategoryMapping);
    }

    @Override
    public void addItems(List<ParentChildCategoryMapping> items)
    {
    }
}
