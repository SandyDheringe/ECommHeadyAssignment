package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.model.roomentities.relation.ProductDetails; /**
 * Contract for view and presenter
 *
 * @author SandeepD
 */
public interface Contracts
{

    interface View
    {
        void initView();

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void onSuccess();
    }

    interface Presenter
    {
        void init();

        void showLoading();

        void hideLoading();

        void addtoCart(ProductDetails productDetails);
    }
}
