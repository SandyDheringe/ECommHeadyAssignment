package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.heady.ecommerce.model.roomentities.ProductRanking;

import java.util.List;

@Dao
public interface ProductRankingDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ProductRanking productRanking);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ProductRanking> productRankingList);
}
