package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.heady.ecommerce.model.roomentities.Product;
import com.heady.ecommerce.model.roomentities.relation.ProductAndVariant;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface ProductDao
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Product> productList);

    @Query("SELECT Product.*,Variant.* FROM Product INNER JOIN Variant ON Product.id = Variant.product_id WHERE Product.category_id=:categoryId")
    Single<List<ProductAndVariant>> getProductAndVariant(int categoryId);

    @Query("SELECT * FROM PRODUCT WHERE Product.category_id=:categoryId")
    Single<List<ProductAndVariant>> getProductList(int categoryId);

    @Query("SELECT Product.*,Variant.*,ProductRanking.* FROM Product " +
            "INNER JOIN Variant ON Product.id = Variant.product_id " +
            "INNER JOIN ProductRanking ON ProductRanking.p_id = Product.id " +
            "WHERE Product.category_id=:categoryId")
    Single<List<ProductDetails>> getProductDetails(int categoryId);

}
