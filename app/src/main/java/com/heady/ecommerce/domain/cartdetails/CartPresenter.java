package com.heady.ecommerce.domain.cartdetails;

import com.heady.ecommerce.dao.repo.Repository;
import com.heady.ecommerce.model.CartSummary;
import com.heady.ecommerce.model.roomentities.relation.CartDetail;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * @author shishank
 */

class CartPresenter implements Contracts.Presenter
{
    private Contracts.View categoryView;
    private boolean isUpdating;
    private Repository repository;
    private CartSummary cartSummary;

    CartPresenter(Contracts.View categoryView, Repository repository)
    {
        super();
        this.categoryView = categoryView;
        this.repository = repository;
        cartSummary = new CartSummary();
    }

    @Override
    public void init()
    {
        categoryView.initView();
    }

    @Override
    public void fetchCartProductDetails()
    {
        showLoading();

        repository.cardData().getCartDetails()
                .subscribeOn(Schedulers.io())
                .map(cartDetails -> {

                    for (CartDetail cartDetail : cartDetails)
                    {
                        int price = cartDetail.variant.getPrice();
                        cartSummary.setCartTotal(cartSummary.getCartTotal() + price);
                        float taxRate = cartDetail.tax.getValue();
                        int tax = (int) ((price * taxRate) / 100);
                        cartSummary.setEstimatedTax(cartSummary.getEstimatedTax() + tax);
                        cartSummary.setTotalPayable(cartSummary.getTotalPayable() + price + tax);
                    }
                    return cartDetails;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess, categoryView::onError);
    }

    private void onSuccess(List<CartDetail> cartDetails)
    {
        categoryView.populateData(cartDetails,cartSummary);
    }


    @Override
    public boolean shouldUpdate()
    {
        return !isUpdating;
    }


    @Override
    public void showLoading()
    {
        categoryView.showLoading();
    }

    @Override
    public void hideLoading()
    {
        categoryView.hideLoading();
    }
}
