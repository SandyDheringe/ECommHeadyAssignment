package com.heady.ecommerce.domain.productdetails;

import com.heady.ecommerce.dao.repo.Repository;
import com.heady.ecommerce.model.response.VariantDTO;
import com.heady.ecommerce.model.roomentities.Cart;
import com.heady.ecommerce.model.roomentities.Variant;
import com.heady.ecommerce.model.roomentities.relation.ProductDetails;

import java.util.ArrayList;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Product detail presenter
 *
 * @author SandeepD
 */
public class ProductDetailPresenter implements Contracts.Presenter
{
    private Contracts.View productListView;
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

    void getProductVariant(int productId)
    {
        Disposable disposable = repository.variantData().getProductVariant(productId)
                .subscribeOn(Schedulers.io())
                .map(variants ->
                {
                    ArrayList<VariantDTO> variantDTOList = new ArrayList<>();
                    for (Variant variant : variants)
                    {
                        variantDTOList.add(new VariantDTO(variant.getVariantId(), variant.getColor(), variant.getSize(), variant.getPrice()));
                    }
                    return variantDTOList;
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(productListView::onVariantFetched, productListView::onError);
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
                        productListView.onAddError(e);
                    }
                });

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
