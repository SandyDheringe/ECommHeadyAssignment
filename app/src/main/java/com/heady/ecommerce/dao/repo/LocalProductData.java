package com.heady.ecommerce.dao.repo;

import com.heady.ecommerce.database.AppDatabase;
import com.heady.ecommerce.model.roomentities.Product;
import com.heady.ecommerce.model.roomentities.relation.ProductAndVariant;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
/**
 * local data source.
 * @author SandeepD
 */
public class LocalProductData implements DataSource<Product>
{

    AppDatabase appDatabase;

    @Inject
    public LocalProductData(AppDatabase appDatabase)
    {
        this.appDatabase = appDatabase;
    }

    @Override
    public void addItem(Product product)
    {
        appDatabase.productDataDao().insert(product);
    }

    @Override
    public void addItems(List<Product> items)
    {

    }

    public Single<List<ProductAndVariant>> getProductByCategory(int categoryId)
    {
        return appDatabase.productDataDao().getProductAndVariant(categoryId);
    }

    public Single<List<ProductAndVariant>> getProductList(int categoryId)
    {
        return appDatabase.productDataDao().getProductList(categoryId);
    }

    public Single<List<ProductDetails>> getProductDetails(int categoryId)
    {
        return appDatabase.productDataDao().getProductDetails(categoryId);
    }
}
