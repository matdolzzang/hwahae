package com.hwahae.soo.hwahaeapplication.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hwahae.soo.hwahaeapplication.Adapter.CategoryRankingAdapter;
import com.hwahae.soo.hwahaeapplication.Model.ProductModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;


public class RankingFragment extends Fragment {
    RecyclerView rankingCategoryRecyclerView;
    CategoryRankingAdapter categoryRankingAdapter;
    ArrayList<ProductModel> products;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.ranking_fragment,container,false);

        products= new ArrayList<>();
        products.add(new ProductModel(getActivity().getDrawable(R.drawable.fristfirst),"스킨1","이니스프리"));
        products.add(new ProductModel(getActivity().getDrawable(R.drawable.firstsecond),"스킨2","더페이스샵"));
        products.add(new ProductModel(getActivity().getDrawable(R.drawable.firstthird),"스킨3","미샤"));
        categoryRankingAdapter= new CategoryRankingAdapter(products);

        rankingCategoryRecyclerView=viewGroup.findViewById(R.id.categoryRecyclerView);
        rankingCategoryRecyclerView.setAdapter(categoryRankingAdapter);
        rankingCategoryRecyclerView.setLayoutManager(new LinearLayoutManager(viewGroup.getContext()));
        categoryRankingAdapter.notifyDataSetChanged();
        return viewGroup;
    }

}
