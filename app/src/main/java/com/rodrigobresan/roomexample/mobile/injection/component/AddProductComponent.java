package com.rodrigobresan.roomexample.mobile.injection.component;

import com.rodrigobresan.roomexample.mobile.add_product.AddProductActivity;
import com.rodrigobresan.roomexample.mobile.list_products.view.ListProductsActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent
public interface AddProductComponent extends AndroidInjector<AddProductActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<AddProductActivity> {
    }

}
