package com.hwahae.soo.hwahaeapplication.Model;

import android.graphics.drawable.Drawable;

public class ProductModel {
    Drawable productImage;
    String title;
    String brand;

    public ProductModel(Drawable productImage, String title, String brand) {
        this.productImage = productImage;
        this.title = title;
        this.brand = brand;
    }

    public Drawable getProductImage() {
        return productImage;
    }

    public void setProductImage(Drawable productImage) {
        this.productImage = productImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
