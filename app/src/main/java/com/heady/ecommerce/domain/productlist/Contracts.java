package com.heady.ecommerce.domain.productlist;

import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.List;

/**
 * Contract for view and presenter
 *
 * @author SandeepD
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

        void sortByMostViewed();

        void sortByMostOrdered();

        void sortByMostShared();

        void showLoading();

        void hideLoading();

        void onDetach();

    }
}
