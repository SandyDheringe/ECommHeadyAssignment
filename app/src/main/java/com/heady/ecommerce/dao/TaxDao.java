package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.heady.ecommerce.model.roomentities.Tax;

import java.util.List;

/**
 * Tax DAO
 *
 * @author SandeepD
 */
@Dao
public interface TaxDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Tax tax);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Tax> taxList);

}
