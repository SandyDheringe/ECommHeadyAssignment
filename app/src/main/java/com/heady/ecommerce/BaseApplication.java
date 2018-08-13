package com.heady.ecommerce;

import android.app.Application;

import timber.log.Timber;

public class BaseApplication extends Application
{
    private AppComponent appComponent;

    @Override
    public void onCreate()
    {
        super.onCreate();

        if (BuildConfig.DEBUG)
        {
            Timber.plant(new Timber.DebugTree());
        }

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        appComponent.inject(this);
    }

    public AppComponent getAppComponent()
    {
        return appComponent;
    }
}
