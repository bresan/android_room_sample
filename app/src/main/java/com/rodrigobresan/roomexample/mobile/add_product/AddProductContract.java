package com.rodrigobresan.roomexample.mobile.add_product;

import com.rodrigobresan.roomexample.base.BasePresenter;
import com.rodrigobresan.roomexample.base.BaseView;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;

public interface AddProductContract {

    interface View extends BaseView<Presenter> {
        void showSuccess();

        void showFailure();
    }

    interface Presenter extends BasePresenter {
        void validateFields();

        void saveProduct(Product product);
    }
}
