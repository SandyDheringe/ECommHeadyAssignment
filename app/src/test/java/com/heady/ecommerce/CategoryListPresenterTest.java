package com.heady.ecommerce;

import com.heady.ecommerce.domain.categorylist.Contracts;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.TimeUnit;

import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.plugins.RxJavaPlugins;

/**
 * @author SandeepD
 */

@RunWith(JUnit4.class)
public class CategoryListPresenterTest
{

    @Mock
    private Contracts.View categoryView;

    @BeforeClass
    public static void setupRxSchedulers()
    {
        Scheduler immediate = new Scheduler()
        {

            @Override
            public Disposable scheduleDirect(Runnable run, long delay, TimeUnit unit)
            {
                return super.scheduleDirect(run, 0, unit);
            }

            @Override
            public Worker createWorker()
            {
                return new ExecutorScheduler.ExecutorWorker(Runnable::run);
            }
        };

        RxJavaPlugins.setInitIoSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitComputationSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitNewThreadSchedulerHandler(scheduler -> immediate);
        RxJavaPlugins.setInitSingleSchedulerHandler(scheduler -> immediate);
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(scheduler -> immediate);
    }

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void validate()
    {
        Mockito.validateMockitoUsage();
    }


}