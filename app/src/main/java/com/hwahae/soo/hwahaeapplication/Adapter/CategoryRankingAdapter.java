package com.hwahae.soo.hwahaeapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwahae.soo.hwahaeapplication.Holder.CategoryRankingHolder;
import com.hwahae.soo.hwahaeapplication.Model.ProductModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class CategoryRankingAdapter extends RecyclerView.Adapter<CategoryRankingHolder> {

    final ArrayList<ProductModel> products;

    public CategoryRankingAdapter(ArrayList<ProductModel> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public CategoryRankingHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int pos) {
        final Context context= viewGroup.getContext();
        final View view= LayoutInflater.from(context).inflate(R.layout.product, viewGroup,false);
        return new CategoryRankingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryRankingHolder categoryRankingHolder, int pos) {
        final ProductModel product= getItem(pos);
        categoryRankingHolder.productImage.setImageDrawable(product.getProductImage());
        categoryRankingHolder.productTitle.setText(product.getTitle());
        categoryRankingHolder.productBrand.setText(product.getBrand());
    }

    public ProductModel getItem(int pos){
        return products.get(pos);
    }

    @Override
    public int getItemCount() {
        int count=0;
        if(products!=null && products.size()>0) count=products.size();
        return count;
    }
}
