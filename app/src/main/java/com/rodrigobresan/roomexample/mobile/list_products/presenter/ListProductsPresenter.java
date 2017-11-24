package com.rodrigobresan.roomexample.mobile.list_products.presenter;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;
import com.rodrigobresan.roomexample.mobile.list_products.model.ProductDao;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;


public class ListProductsPresenter implements ListProductsContract.Presenter {

    private ProductDao productDao;
    private ListProductsContract.View view;

    @Inject
    public ListProductsPresenter(ListProductsContract.View view, ProductDao productDao) {
        this.view = view;
        this.view.setPresenter(this);
        this.productDao = productDao;
    }

    @Override
    public void loadProducts() {
        productDao.getAll().observeForever(new Observer<List<Product>>() {
            @Override
            public void onChanged(@Nullable List<Product> productList) {
                view.showProducts(productList);
            }
        });
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }
}
