package com.heady.ecommerce.dao.repo;

import com.heady.ecommerce.database.AppDatabase;
import com.heady.ecommerce.model.roomentities.Tax;

import java.util.List;

import javax.inject.Inject;
/**
 * local data source.
 * @author SandeepD
 */
public class LocalTaxData implements DataSource<Tax>
{

    AppDatabase appDatabase;

    @Inject
    public LocalTaxData(AppDatabase appDatabase)
    {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(Tax tax)
    {
        appDatabase.taxDataDao().insert(tax);
    }

    @Override
    public void addItems(List<Tax> items)
    {

    }
}
