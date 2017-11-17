package com.rodrigobresan.roomexample.mobile.injection.module;

import android.app.Application;
import android.content.Context;

import com.rodrigobresan.roomexample.mobile.injection.scope.PerApplication;
import com.rodrigobresan.roomexample.mobile.list_products.model.AppDatabase;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    @Provides
    @PerApplication
    public Context provideContext(Application application) {
        return application;
    }

    @Provides
    @PerApplication
    public AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getDatabase(context);
    }

}
