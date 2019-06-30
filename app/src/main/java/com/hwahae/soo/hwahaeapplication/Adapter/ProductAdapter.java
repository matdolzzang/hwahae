package com.hwahae.soo.hwahaeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hwahae.soo.hwahaeapplication.Model.ProductModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class ProductAdapter extends BaseAdapter {

    ArrayList<ProductModel> products = new ArrayList<>();

    @Override
    public int getCount() {
        int count =0;
        if(products!=null && products.size()>0) count= products.size();
        return count;
    }

    @Override
    public Object getItem(int pos) {
        return products.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        Context context= viewGroup.getContext();
        if(view==null){
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(R.layout.product,viewGroup,false);
        }
        //final ImageView hotImageView= view.findViewById(R.id.hotImage);
        final ImageView productImageView= view.findViewById(R.id.productImage);
        final TextView productTitle= view.findViewById(R.id.productTitle);
        final TextView brandContent= view.findViewById(R.id.productBrand);

        productImageView.setImageDrawable(products.get(pos).getProductImage());
        productTitle.setText(products.get(pos).getTitle());
        brandContent.setText(products.get(pos).getBrand());
        return view;
    }

    public void addItem(ProductModel product){
        products.add(product);
    }

    public void addItems(ArrayList<ProductModel> models){
        products.addAll(models);
    }
}
