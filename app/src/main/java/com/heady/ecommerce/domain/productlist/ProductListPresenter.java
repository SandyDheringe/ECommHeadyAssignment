package com.heady.ecommerce.domain.productlist;

import com.heady.ecommerce.dao.repo.Repository;
import com.heady.ecommerce.model.roomentities.Category;
import com.heady.ecommerce.model.roomentities.relation.CategoryAndMapping;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author shishank
 */

public class ProductListPresenter implements Contracts.Presenter
{
    private Contracts.View productListView;
    private boolean isUpdating;
    private Repository repository;

    ProductListPresenter(Contracts.View productListView, Repository repository)
    {
        super();
        this.productListView = productListView;
        this.repository = repository;
    }

    @Override
    public void init()
    {
        productListView.initView();
    }

    @Override
    public void fetchProductByCategory(int categoryId)
    {
        showLoading();

        repository.productData().getProductDetails(categoryId).
                subscribeOn(Schedulers.io())
                .map(productDetailsList -> {
                    return productDetailsList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(productListView::populateData, this::onError);
    }


    void onError(Throwable throwable)
    {
        throwable.printStackTrace();
    }

    List<Category> parentCategoryList;
    List<CategoryAndMapping> childCategoryList;


    @Override
    public boolean shouldUpdate()
    {
        return !isUpdating;
    }

    @Override
    public void sortByMostViewed()
    {
        List<ProductDetails> productDetailsList = productListView.getProductList();
        Collections.sort(productDetailsList, new ProductDetails.MostViewedComparator());
        productListView.populateData(productDetailsList);
    }

    @Override
    public void sortByMostOrdered()
    {
        List<ProductDetails> productDetailsList = productListView.getProductList();
        Collections.sort(productDetailsList, new ProductDetails.MostOrderedComparator());
        productListView.populateData(productDetailsList);
    }

    @Override
    public void sortByMostShared()
    {
        List<ProductDetails> productDetailsList = productListView.getProductList();
        Collections.sort(productDetailsList, new ProductDetails.MostSharedComparator());
        productListView.populateData(productDetailsList);
    }

    @Override
    public void showLoading()
    {
        productListView.showLoading();
    }

    @Override
    public void hideLoading()
    {
        productListView.hideLoading();
    }
}
