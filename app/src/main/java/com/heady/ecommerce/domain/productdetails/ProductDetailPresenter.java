package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.dao.repo.Repository;
import com.heady.ecommerce.model.roomentities.Cart;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @author shishank
 */

public class ProductDetailPresenter implements Contracts.Presenter
{
    private Contracts.View productListView;
    private boolean isUpdating;
    private Repository repository;

    ProductDetailPresenter(Contracts.View productListView, Repository repository)
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
    public void addtoCart(ProductDetails productDetails)
    {
        Completable.fromAction(() -> {

                Cart cart = new Cart(productDetails.getVariantId(), productDetails.getId(), 1);

                repository.cardData().addItem(cart);

        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver()
                {
                    @Override
                    public void onSubscribe(Disposable d)
                    {
                    }

                    @Override
                    public void onComplete()
                    {
                        productListView.onSuccess();

                    }

                    @Override
                    public void onError(Throwable e)
                    {
                        productListView.onError(e);
                    }
                });

    }

    @Override
    public boolean shouldUpdate()
    {
        return !isUpdating;
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
