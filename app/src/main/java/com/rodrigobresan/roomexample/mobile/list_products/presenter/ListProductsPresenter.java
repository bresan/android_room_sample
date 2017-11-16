package com.rodrigobresan.roomexample.mobile.list_products.presenter;

import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class ListProductsPresenter implements ListProductsContract.Presenter {

    private ListProductsContract.View view;

    @Inject
    public ListProductsPresenter(ListProductsContract.View view) {
        this.view = view;
        this.view.setPresenter(this);
    }

    @Override
    public void loadProducts() {
        // dummy data for now
        List<Product> productList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            productList.add(new Product((long) i, "Product " + i, "Description", i));
        }

        view.showProducts(productList);
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
