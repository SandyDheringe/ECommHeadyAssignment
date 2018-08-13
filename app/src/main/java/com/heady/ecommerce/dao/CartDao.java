package com.heady.ecommerce.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.heady.ecommerce.model.roomentities.Cart;
import com.heady.ecommerce.model.roomentities.relation.CartDetail;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface CartDao
{

    @Insert()
    void insert(Cart cart);

    @Insert()
    void insertAll(List<Cart> cartList);


    @Query("SELECT Product.*, Variant.*, Tax.*, Cart.* FROM " +
            "Product, Variant,Tax,Cart,ProductTax where Product.id = Variant.product_id AND" +
            " Product.id = Cart.prod_id AND Variant.variant_id = Cart.var_id AND" +
            " Tax.name = ProductTax.tax_name AND ProductTax.product_id = Product.id ")
    Single<List<CartDetail>> getCartDetails();
}
