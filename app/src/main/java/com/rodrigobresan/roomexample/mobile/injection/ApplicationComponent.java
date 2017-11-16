package com.rodrigobresan.roomexample.mobile.injection;

import android.app.Application;

import com.rodrigobresan.roomexample.mobile.StoreApplication;
import com.rodrigobresan.roomexample.mobile.injection.module.ActivityBindingModule;
import com.rodrigobresan.roomexample.mobile.injection.module.ApplicationModule;
import com.rodrigobresan.roomexample.mobile.injection.scope.PerApplication;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

@PerApplication
@Component(modules = {ActivityBindingModule.class,
        ApplicationModule.class,
        AndroidSupportInjectionModule.class})
public interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        ApplicationComponent build();
    }

    void inject(StoreApplication app);
}
