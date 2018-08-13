package com.heady.ecommerce;

import android.app.Application;

import com.heady.ecommerce.database.AppDatabase;

import dagger.Module;

@Module
public class RoomModule
{
    AppDatabase  appDatabase;

    RoomModule(Application   application)
    {

    }
}
