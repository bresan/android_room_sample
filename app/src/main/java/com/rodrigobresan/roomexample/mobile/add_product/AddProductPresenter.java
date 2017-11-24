package com.rodrigobresan.roomexample.mobile.add_product;

import com.rodrigobresan.roomexample.mobile.list_products.model.Product;
import com.rodrigobresan.roomexample.mobile.list_products.model.ProductDao;

import javax.inject.Inject;

public class AddProductPresenter implements AddProductContract.Presenter {

    private ProductDao productDao;
    private AddProductContract.View view;

    @Inject
    public AddProductPresenter(AddProductContract.View view, ProductDao productDao) {
        this.view = view;
        this.view.setPresenter(this);
        this.productDao = productDao;
    }

    @Override
    public void validateFields() {

    }

    @Override
    public void saveProduct(Product product) {
        productDao.insert(product);
        view.showSuccess();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
