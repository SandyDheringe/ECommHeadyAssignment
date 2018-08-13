package com.heady.ecommerce.domain.cartdetails;

import android.os.Bundle;

import com.heady.ecommerce.BaseToolBarActivity;
import com.heady.ecommerce.R;
import com.heady.ecommerce.util.ActivityUtil;

/**
 * This activity shows the shopping bag.
 * This is in all separate module which may need to call from various places.
 *
 * @author SandeepD
 */
public class CartActivity extends BaseToolBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        ActivityUtil.replaceFragment(this, null, CartFragment.newInstance(), false, R.id.content_frame);

    }

}
