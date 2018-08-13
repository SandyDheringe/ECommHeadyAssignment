package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.heady.ecommerce.model.roomentities.ParentChildCategoryMapping;

import java.util.List;

@Dao
public interface ParentChildCategoryMappingDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ParentChildCategoryMapping parentChildCategoryMapping);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ParentChildCategoryMapping> parentChildCategoryMappingList);
}
