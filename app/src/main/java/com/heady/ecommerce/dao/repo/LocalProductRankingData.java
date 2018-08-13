package com.heady.ecommerce.dao.repo;

import com.heady.ecommerce.database.AppDatabase;
import com.heady.ecommerce.model.roomentities.ProductRanking;

import java.util.List;

import javax.inject.Inject;

public class LocalProductRankingData implements DataSource<ProductRanking>
{

    AppDatabase appDatabase;

    @Inject
    public LocalProductRankingData(AppDatabase appDatabase)
    {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(ProductRanking productRanking)
    {
        appDatabase.productRankingDataDao().insert(productRanking);
    }

    @Override
    public void addItems(List<ProductRanking> items)
    {

    }
}
