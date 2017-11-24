package com.rodrigobresan.roomexample.mobile.injection.module;

import com.rodrigobresan.roomexample.mobile.add_product.AddProductActivity;
import com.rodrigobresan.roomexample.mobile.add_product.AddProductContract;
import com.rodrigobresan.roomexample.mobile.add_product.AddProductPresenter;
import com.rodrigobresan.roomexample.mobile.injection.scope.PerActivity;
import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.AppDatabase;
import com.rodrigobresan.roomexample.mobile.list_products.model.ProductDao;
import com.rodrigobresan.roomexample.mobile.list_products.presenter.ListProductsPresenter;
import com.rodrigobresan.roomexample.mobile.list_products.view.ListProductsActivity;

import dagger.Module;
import dagger.Provides;

@Module
public class AddProductModule {

    @Provides
    @PerActivity
    public ProductDao provideProductDao(AppDatabase database) {
        return database.productDao();
    }

    @Provides
    @PerActivity
    public AddProductContract.View provideAddProductView(AddProductActivity addProductActivity) {
        return addProductActivity;
    }

    @Provides
    @PerActivity
    public AddProductContract.Presenter provideAddProductPresenter(AddProductContract.View view
            , ProductDao productDao) {
        return new AddProductPresenter(view, productDao);
    }
}
