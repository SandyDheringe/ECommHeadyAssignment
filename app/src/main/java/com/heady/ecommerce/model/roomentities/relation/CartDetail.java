package com.heady.ecommerce.model.roomentities.relation;

import android.arch.persistence.room.Embedded;

import com.heady.ecommerce.model.roomentities.Cart;
import com.heady.ecommerce.model.roomentities.Product;
import com.heady.ecommerce.model.roomentities.Tax;
import com.heady.ecommerce.model.roomentities.Variant;

public class CartDetail
{
    @Embedded
    public Product product;

    @Embedded
    public Variant variant;

    @Embedded
    public Tax tax;

    @Embedded
    public Cart cart;

    public Product getProduct()
    {
        return product;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

    public Variant getVariant()
    {
        return variant;
    }

    public void setVariant(Variant variant)
    {
        this.variant = variant;
    }

    public Tax getTax()
    {
        return tax;
    }

    public void setTax(Tax tax)
    {
        this.tax = tax;
    }

    public Cart getCart()
    {
        return cart;
    }

    public void setCart(Cart cart)
    {
        this.cart = cart;
    }
}
