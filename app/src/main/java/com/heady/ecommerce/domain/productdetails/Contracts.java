package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.model.response.VariantDTO;
import com.heady.ecommerce.model.roomentities.Variant;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.ArrayList;
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

        void onError(Throwable throwable);

        void showLoading();

        void hideLoading();

        void onSuccess();

        void onVariantSelected(VariantDTO variantDTO);

        void onVariantFetched(ArrayList<VariantDTO> variants);

        void onAddError(Throwable e);
    }

    interface Presenter
    {
        void init();

        void showLoading();

        void hideLoading();

        void addtoCart(ProductDetails productDetails);
    }
}
