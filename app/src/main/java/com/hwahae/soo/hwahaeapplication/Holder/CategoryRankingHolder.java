package com.hwahae.soo.hwahaeapplication.Holder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hwahae.soo.hwahaeapplication.R;

public class CategoryRankingHolder extends RecyclerView.ViewHolder {

    public ImageView productImage;
    public TextView productTitle;
    public TextView productBrand;

    public CategoryRankingHolder(@NonNull View itemView) {
        super(itemView);
        productImage=itemView.findViewById(R.id.productImage);
        productTitle=itemView.findViewById(R.id.productTitle);
        productBrand=itemView.findViewById(R.id.productBrand);
    }


    public ImageView getProductImage() {
        return productImage;
    }

    public void setProductImage(ImageView productImage) {
        this.productImage = productImage;
    }

    public TextView getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(TextView productTitle) {
        this.productTitle = productTitle;
    }

    public TextView getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(TextView productBrand) {
        this.productBrand = productBrand;
    }
}
