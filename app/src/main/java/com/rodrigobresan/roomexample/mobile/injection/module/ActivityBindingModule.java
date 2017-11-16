package com.rodrigobresan.roomexample.mobile.injection.module;

import com.rodrigobresan.roomexample.mobile.injection.scope.PerActivity;
import com.rodrigobresan.roomexample.mobile.list_products.view.ListProductsActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = ListProductsModule.class)
    abstract ListProductsActivity bindProductsActivity();
}
