package com.rodrigobresan.roomexample.mobile.list_products.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.rodrigobresan.roomexample.R;
import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;
import com.rodrigobresan.roomexample.mobile.list_products.view.adapter.ProductAdapter;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;

public class ListProductsActivity extends AppCompatActivity implements ListProductsContract.View {

    @Inject
    ListProductsContract.Presenter presenter;

    private RecyclerView rvProducts;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);

        setContentView(R.layout.activity_list_products);

        setupRecyclerView();
        presenter.loadProducts();
    }

    private void setupRecyclerView() {
        rvProducts = findViewById(R.id.rv_products);
        productAdapter = new ProductAdapter();

        rvProducts.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        rvProducts.setAdapter(productAdapter);
    }

    @Override
    public void showProducts(List<Product> productList) {
        productAdapter.setProductList(productList);
    }

    @Override
    public void showEmptyView() {

    }

    @Override
    public void showNoConnectionView() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void setPresenter(ListProductsContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
