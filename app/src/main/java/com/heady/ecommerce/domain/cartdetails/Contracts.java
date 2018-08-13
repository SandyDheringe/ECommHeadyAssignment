package com.heady.ecommerce.domain.cartdetails;

import com.heady.ecommerce.model.CartSummary;
import com.heady.ecommerce.model.roomentities.relation.CartDetail;

import java.util.List;

/**
 * @author shishank
 */

interface Contracts
{

    interface View
    {
        void initView();

        void populateData(List<CartDetail> categoryDTOList, CartSummary cartSummary);

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void removeFromCart();
    }

    interface Presenter
    {
        void init();

        void fetchCartProductDetails();

        boolean shouldUpdate();

        void showLoading();

        void hideLoading();

    }
}
