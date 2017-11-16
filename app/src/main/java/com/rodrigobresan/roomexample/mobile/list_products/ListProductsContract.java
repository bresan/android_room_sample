package com.rodrigobresan.roomexample.mobile.list_products;

import com.rodrigobresan.roomexample.base.BasePresenter;
import com.rodrigobresan.roomexample.base.BaseView;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;

import java.util.List;

public interface ListProductsContract {
    interface View extends BaseView<Presenter> {
        void showProducts(List<Product> productList);

        void showEmptyView();

        void showNoConnectionView();
    }

    interface Presenter extends BasePresenter {
        void loadProducts();
    }
}
