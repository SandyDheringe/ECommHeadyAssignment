package com.heady.ecommerce.model.roomentities.relation;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.heady.ecommerce.model.roomentities.Product;
import com.heady.ecommerce.model.roomentities.Variant;

import java.util.List;

public class ProductAndVariant
{
    @Embedded
    public Product product;

    @Relation(parentColumn = "id", entityColumn = "product_id")

//    @Embedded
    public List<Variant> variants;
}
