package com.rodrigobresan.roomexample.mobile.injection.module;

import com.rodrigobresan.roomexample.mobile.injection.scope.PerActivity;
import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.AppDatabase;
import com.rodrigobresan.roomexample.mobile.list_products.model.ProductDao;
import com.rodrigobresan.roomexample.mobile.list_products.presenter.ListProductsPresenter;
import com.rodrigobresan.roomexample.mobile.list_products.view.ListProductsActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class ListProductsModule {

    @Provides
    @PerActivity
    public ProductDao provideProductDao(AppDatabase database) {
        return database.productDao();
    }

    @Provides
    @PerActivity
    public ListProductsContract.View provideProductsView(ListProductsActivity listProductsActivity) {
        return listProductsActivity;
    }

    @Provides
    @PerActivity
    public ListProductsContract.Presenter provideProductsPresenter(ListProductsContract.View view
            , ProductDao productDao) {
        return new ListProductsPresenter(view, productDao);
    }
}
