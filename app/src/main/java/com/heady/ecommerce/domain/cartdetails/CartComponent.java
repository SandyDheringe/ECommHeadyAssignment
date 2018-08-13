package com.heady.ecommerce.domain.cartdetails;

import dagger.Subcomponent;


/**
 * Created by SandeepD
 * on 15/05/18.
 * <p>
 * Custom scope for category screen, this is a child component of App Component
 * and needs to be smaller in size
 */
@CartScope
@Subcomponent(modules = {CartModule.class})
public interface CartComponent
{
    void inject(CartFragment cartFragment);

}