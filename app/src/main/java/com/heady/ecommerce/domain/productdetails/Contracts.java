package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.model.roomentities.relation.ProductDetails; /**
 * @author shishank
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

        //void fetchProductByProductId(int productId);

        boolean shouldUpdate();

        void showLoading();

        void hideLoading();

        void addtoCart(ProductDetails productDetails);
    }
}
