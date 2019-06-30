package com.hwahae.soo.hwahaeapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.Model.CategoryModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class CategoryAdapter extends BaseAdapter {
    ArrayList<CategoryModel> categories=new ArrayList<>();
    @Override
    public int getCount() {
        int count=0;
        if(categories!=null && categories.size()>0) count=categories.size();
        return count;
    }

    @Override
    public Object getItem(int pos) {
        return categories.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        Context context= viewGroup.getContext();
        if(view==null){
            LayoutInflater inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view= inflater.inflate(R.layout.category,viewGroup,false);
        }
        //final TextView title= view.findViewById(R.id.categoryTitle);
        final ImageView image = view.findViewById(R.id.categoryImage);
        //title.setText(categories.get(pos).getTitle());
        image.setImageDrawable(categories.get(pos).getCategoryImage());
        return view;
    }

    public void addItem(CategoryModel model){
        categories.add(model);
    }

    public void addItems(ArrayList<CategoryModel> models){
        categories.addAll(models);
    }
}
