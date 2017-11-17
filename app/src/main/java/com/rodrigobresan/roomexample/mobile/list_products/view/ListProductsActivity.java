package com.rodrigobresan.roomexample.mobile.list_products.view;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.rodrigobresan.roomexample.R;
import com.rodrigobresan.roomexample.mobile.list_products.ListProductsContract;
import com.rodrigobresan.roomexample.mobile.list_products.model.AppDatabase;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;
import com.rodrigobresan.roomexample.mobile.list_products.view.adapter.ProductAdapter;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListProductsActivity extends AppCompatActivity implements ListProductsContract.View {

    @Inject
    ListProductsContract.Presenter presenter;

    private RecyclerView rvProducts;
    private FloatingActionButton fabAdd;

    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);

        setContentView(R.layout.activity_list_products);

        setupRecyclerView();
        setUpViews();
        presenter.loadProducts();
    }

    private void setUpViews() {
        fabAdd = findViewById(R.id.fab_add_product);
        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addRandomProduct();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_refresh, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_menu_refresh: {
                presenter.loadProducts();
            }
        }
        return super.onOptionsItemSelected(item);
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

        for (Product product : productList) {
            Log.d("LOG", "current product: " + product.getName());
        }
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
