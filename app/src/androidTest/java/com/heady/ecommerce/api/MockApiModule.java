package com.heady.ecommerce.api;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author SandeepD
 */
@Module
public class MockApiModule
{

    @Provides
    @Singleton
    ApiService providesApiService()
    {
        return new MockApiService();
    }
}
