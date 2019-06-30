package com.hwahae.soo.hwahaeapplication.Model;

import android.graphics.drawable.Drawable;

public class CategoryModel {
    //String title;
    Drawable categoryImage;

    public CategoryModel(Drawable categoryImage) {
        //this.title = title;
        this.categoryImage = categoryImage;
    }

    public Drawable getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Drawable categoryImage) {
        this.categoryImage = categoryImage;
    }
}
