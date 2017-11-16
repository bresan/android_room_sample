package com.rodrigobresan.roomexample.mobile.list_products.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rodrigobresan.roomexample.R;
import com.rodrigobresan.roomexample.mobile.list_products.model.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product currentProduct = productList.get(position);

        holder.txtTitle.setText(currentProduct.getName());
        holder.imgThumbnail.setImageResource(R.drawable.ic_launcher_background);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public ImageView imgThumbnail;

        public ProductViewHolder(View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txt_item_product_title);
            imgThumbnail = itemView.findViewById(R.id.img_item_product_thumbnail);
        }
    }
}
