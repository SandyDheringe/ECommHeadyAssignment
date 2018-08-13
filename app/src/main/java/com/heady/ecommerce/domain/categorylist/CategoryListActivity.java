package com.heady.ecommerce.domain.categorylist;

import android.os.Bundle;
import android.view.Menu;

import com.heady.ecommerce.BaseToolBarActivity;
import com.heady.ecommerce.R;
import com.heady.ecommerce.util.ActivityUtil;


public class CategoryListActivity extends BaseToolBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        ActivityUtil.replaceFragment(this, null, CategoryListFragment.newInstance(), false, R.id.content_frame);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
