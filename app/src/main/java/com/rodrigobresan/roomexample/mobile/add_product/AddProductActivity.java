package com.rodrigobresan.roomexample.mobile.add_product;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rodrigobresan.roomexample.R;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class AddProductActivity extends AppCompatActivity implements View.OnClickListener, AddProductContract.View {

    private EditText editId, editName, editCount, editNotes;
    private FloatingActionButton fabSave;

    @Inject
    AddProductContract.Presenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AndroidInjection.inject(this);
        setContentView(R.layout.activity_add_product);

        initUiComponents();
    }

    private void initUiComponents() {
        editId = findViewById(R.id.ed_add_product_id);
        editName = findViewById(R.id.ed_add_product_name);
        editNotes = findViewById(R.id.ed_add_product_notes);
        editCount = findViewById(R.id.ed_add_product_count);

        fabSave = findViewById(R.id.fab_add_product_save);
        fabSave.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_add_product_save: {
                saveProduct();
            }
        }
    }

    private void saveProduct() {
        if (fieldsAreValid()) {
            long id = Long.parseLong(editId.getText().toString());
            String name = editName.getText().toString();
            String notes = editNotes.getText().toString();
            int count = Integer.parseInt(editCount.getText().toString());

            Product product = new Product(id, name, notes, count);

            presenter.saveProduct(product);
        }
    }

    private boolean fieldsAreValid() {

        if (editId.getText().toString().isEmpty()) {
            showMessage("Id vazio");
            return false;
        }

        if (editName.getText().toString().isEmpty()) {
            showMessage("Nome vazio");
            return false;
        }

        if (editNotes.getText().toString().isEmpty()) {
            showMessage("Notas vazio");
            return false;
        }

        if (editCount.getText().toString().isEmpty()) {
            showMessage("Qtde vazio");
            return false;
        }

        return true;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSuccess() {
        Toast.makeText(this, "Adicionado com sucesso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailure() {
        Toast.makeText(this, "Erro ao adicionar", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(AddProductContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
