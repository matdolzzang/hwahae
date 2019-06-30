package com.hwahae.soo.hwahaeapplication.Fragment;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.hwahae.soo.hwahaeapplication.Activity.BrandRankingActivity;
import com.hwahae.soo.hwahaeapplication.Activity.CategoryActivity;
import com.hwahae.soo.hwahaeapplication.Adapter.CategoryAdapter;
import com.hwahae.soo.hwahaeapplication.Adapter.ProductAdapter;
import com.hwahae.soo.hwahaeapplication.Model.CategoryModel;
import com.hwahae.soo.hwahaeapplication.Model.ProductModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    TabLayout tabLayout;
    ViewFlipper viewFlipper;
    ViewFlipper bottomViewFlipper;
    ImageView homeImage;
    Toolbar mToolbar;
    GridView gridView;
    GridView productGridView;
    Button loadingButton;
    Fragment selected;
    RankingFragment rankingFragment=new RankingFragment();

    final ArrayList<ImageView> bottomImages = new ArrayList<>();

    final int NUM_OF_CATEGORIES=6;

//    public static HomeFragment newInstance() {
//        HomeFragment homeFragment = new HomeFragment();
//        return homeFragment;
//    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.activity_main,container,false);

        viewFlipper=viewGroup.findViewById(R.id.mainViewFlipper);
        ImageView flipViewImageOne= new ImageView(viewGroup.getContext());
        flipViewImageOne.setImageDrawable(getActivity().getDrawable(R.drawable.adtop));
        flipViewImageOne.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView flipViewImageTwo= new ImageView(viewGroup.getContext());
        flipViewImageTwo.setImageDrawable(getActivity().getDrawable(R.drawable.adtoptwo));
        flipViewImageTwo.setScaleType(ImageView.ScaleType.FIT_XY);
        ImageView flipViewImageThree =new ImageView(viewGroup.getContext());
        flipViewImageThree.setImageDrawable(getActivity().getDrawable(R.drawable.adtopthree));
        flipViewImageThree.setScaleType(ImageView.ScaleType.FIT_XY);
        Animation animation= AnimationUtils.loadAnimation(viewGroup.getContext(),android.R.anim.slide_in_left);

        viewFlipper.addView(flipViewImageOne);
        viewFlipper.addView(flipViewImageTwo);
        viewFlipper.addView(flipViewImageThree);
        viewFlipper.setAnimation(animation);
        viewFlipper.setFlipInterval(1500);
        viewFlipper.startFlipping();

        gridView= viewGroup.findViewById(R.id.mainCategoryGridView);

        ArrayList<CategoryModel> models = new ArrayList<>();

        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryone)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorytwo)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorythree)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryfour)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryfive)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorysix)));

        CategoryAdapter mainCategoryAdapter= new CategoryAdapter();

        //@Error :Caused by: java.lang.RuntimeException: Don't call setOnClickListener for an AdapterView.
        // You probably want setOnItemClickListener instead
//        gridView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Log.d("HomeFragment Pos",String.valueOf(pos));
                Intent intent= new Intent();
                if(pos==0){
                    intent= new Intent(getActivity(),CategoryActivity.class);
                }else if(pos==1){
                    intent= new Intent(getActivity(),BrandRankingActivity.class);
                }else if(pos==2){

                }else if(pos==3){

                }else if(pos==4){

                }else if(pos==5){

                }
                getActivity().startActivity(intent);
            }
        });


        mainCategoryAdapter.addItems(models);
        gridView.setAdapter(mainCategoryAdapter);

        productGridView= viewGroup.findViewById(R.id.mainProductPopularityGridView);

        ArrayList<ProductModel> productModels= new ArrayList<>();

        productModels.add(new ProductModel(getActivity().getDrawable(R.drawable.skin),"크림 스킨 미스트","라네즈(LANEIGE)"));
        productModels.add(new ProductModel(getActivity().getDrawable(R.drawable.lotiontwo),"대나무 힐링 마스크","비플레인(BEPLAIN)"));
        productModels.add(new ProductModel(getActivity().getDrawable(R.drawable.lotionone),"그린 선 칼라 업 선 스틱","블랑쉐(BLANCHET)"));


        ProductAdapter mainProductAdapter= new ProductAdapter();

        mainProductAdapter.addItems(productModels);
        productGridView.setAdapter(mainProductAdapter);
        bottomViewFlipper= viewGroup.findViewById(R.id.mainBottomViewFlipper);

        ImageView image=new ImageView(viewGroup.getContext());
        image.setImageDrawable(getActivity().getDrawable(R.drawable.adbottom));
        //addBottomAd(image);

        ImageView image1=new ImageView(viewGroup.getContext());
        image1.setImageDrawable(getActivity().getDrawable(R.drawable.adbottomtwo));
        ///addBottomAd(image1);

        ImageView image2=new ImageView(viewGroup.getContext());
        image2.setImageDrawable(getActivity().getDrawable(R.drawable.adbottomthree));
        ///addBottomAd(image2);

        ImageView image3=new ImageView(viewGroup.getContext());
        image3.setImageDrawable(getActivity().getDrawable(R.drawable.adbottomfour));
        ///addBottomAd(image3);

        bottomViewFlipper.addView(image);
        bottomViewFlipper.addView(image1);
        bottomViewFlipper.addView(image2);
        bottomViewFlipper.addView(image3);


        Animation bottomAnimation= AnimationUtils.loadAnimation(viewGroup.getContext(),android.R.anim.slide_in_left);
        bottomViewFlipper.setAnimation(bottomAnimation);
        bottomViewFlipper.setFlipInterval(1500);
        bottomViewFlipper.startFlipping();

        loadingButton= getActivity().findViewById(R.id.btn_progress);
        return viewGroup;

    }



}
