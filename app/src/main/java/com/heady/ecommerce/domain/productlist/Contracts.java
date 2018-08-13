package com.heady.ecommerce.domain.productlist;

import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.List;

/**
 * @author shishank
 */

public interface Contracts
{

    interface View
    {
        void initView();

        void populateData(List<ProductDetails> productDetailsList);

        void onCategoryItemSelected(ProductDetails productDetails);

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void sortProduct(int criteria);
        List<ProductDetails> getProductList();
    }

    interface Presenter
    {
        void init();

        void fetchProductByCategory(int categoryId);

        boolean shouldUpdate();

        void sortByMostViewed();

        void sortByMostOrdered();

        void sortByMostShared();

        void showLoading();


        void hideLoading();
    }
}
