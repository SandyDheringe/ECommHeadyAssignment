package com.heady.ecommerce.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.heady.ecommerce.dao.CartDao;
import com.heady.ecommerce.dao.CategoryDao;
import com.heady.ecommerce.dao.ParentChildCategoryMappingDao;
import com.heady.ecommerce.dao.ProductDao;
import com.heady.ecommerce.dao.ProductRankingDao;
import com.heady.ecommerce.dao.ProductTaxDao;
import com.heady.ecommerce.dao.TaxDao;
import com.heady.ecommerce.dao.VariantDao;
import com.heady.ecommerce.model.roomentities.Cart;
import com.heady.ecommerce.model.roomentities.Category;
import com.heady.ecommerce.model.roomentities.ParentChildCategoryMapping;
import com.heady.ecommerce.model.roomentities.Product;
import com.heady.ecommerce.model.roomentities.ProductRanking;
import com.heady.ecommerce.model.roomentities.ProductTax;
import com.heady.ecommerce.model.roomentities.Tax;
import com.heady.ecommerce.model.roomentities.Variant;

/**
 * @author sandeepD
 */
@Database(entities = {Category.class, Product.class, Tax.class, Variant.class, ProductTax.class,
        ProductRanking.class, ParentChildCategoryMapping.class, Cart.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract CategoryDao categoryDataDao();

    public abstract ProductDao productDataDao();

    public abstract TaxDao taxDataDao();

    public abstract VariantDao variantDataDao();

    public abstract ProductTaxDao productTaxDataDao();

    public abstract ProductRankingDao productRankingDataDao();

    public abstract ParentChildCategoryMappingDao parentChildCategoryMappingDataDao();

    public abstract CartDao cartDao();
}
