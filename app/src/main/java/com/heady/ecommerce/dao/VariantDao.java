package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.heady.ecommerce.model.roomentities.Variant;

import java.util.List;

/**
 * Variant DAO
 *
 * @author SandeepD
 */
@Dao
public interface VariantDao
{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Variant variant);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Variant> variantList);
}
