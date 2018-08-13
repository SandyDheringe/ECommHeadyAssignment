package com.heady.ecommerce.domain.cartdetails;

import android.os.Bundle;
import android.view.Menu;

import com.heady.ecommerce.BaseToolBarActivity;
import com.heady.ecommerce.R;
import com.heady.ecommerce.util.ActivityUtil;


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
