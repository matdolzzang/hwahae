package com.hwahae.soo.hwahaeapplication.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.media.Image;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.Adapter.TabAdapter;
import com.hwahae.soo.hwahaeapplication.Fragment.AwardFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.EventFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.HomeFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.HwapleFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.MainPopupDialogFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.RankingFragment;
import com.hwahae.soo.hwahaeapplication.Fragment.ShoppingFragment;
import com.hwahae.soo.hwahaeapplication.R;


public class MainActivity extends AppCompatActivity {
    Toolbar mToolbar;
    TabLayout tabLayout;
    Fragment selected;
    HomeFragment homeFragment;
    RankingFragment rankingFragment;
    ShoppingFragment shoppingFragment;
    ViewPager viewPager;
    TabAdapter tabAdapter;
    MainPopupDialogFragment mainPopupDialogFragment;
    ImageView imageView;


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle("종료 안내").setMessage("종료 하시겠습니까?").setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {Log.d("MainActivity","Exit");
                System.exit(0);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        final Bundle bundle=savedInstanceState;
        homeFragment= new HomeFragment();
        rankingFragment=new RankingFragment();
        shoppingFragment=new ShoppingFragment();
        mainPopupDialogFragment =new MainPopupDialogFragment();
        selected= homeFragment;
        viewPager= findViewById(R.id.pager);
        mToolbar= findViewById(R.id.toolbar_dark);
        imageView=mToolbar.findViewById(R.id.logo_nav);

        onBackPressed();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity","Toolbar Clicked");

//                getSupportFragmentManager().beginTransaction().
//                        replace(R.id.mainContainer,homeFragment).commit();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
              startActivity(intent);
            }
        });




        setSupportActionBar(mToolbar);

        tabAdapter= new TabAdapter(getSupportFragmentManager());
        tabAdapter.addFragment(new HomeFragment(), "홈");
        tabAdapter.addFragment(new RankingFragment(), "랭킹");
        tabAdapter.addFragment(new ShoppingFragment(),"쇼핑");
        tabAdapter.addFragment(new HwapleFragment(),"화플");
        tabAdapter.addFragment(new EventFragment(),"이벤트");
        tabAdapter.addFragment(new AwardFragment(),"어워드");

        viewPager.setAdapter(tabAdapter);

        tabLayout= findViewById(R.id.mainTab);
        tabLayout.setupWithViewPager(viewPager);


        getSupportFragmentManager().beginTransaction().
                replace(R.id.mainContainer,homeFragment).commit();

        mainPopupDialogFragment.show(getSupportFragmentManager(),"MainPopupDialogFragment");

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int pos= tab.getPosition();
                if(pos==0){
                    selected= homeFragment;
                }else if(pos==1){
                    selected= rankingFragment;
                }else if(pos==2){
                    selected= shoppingFragment;

                }else if(pos==3){

                }else if(pos==4){

                }else if(pos==5){

                }
                if(pos<3){
                getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainContainer,selected).commit();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                int pos= tab.getPosition();
                if(pos==0){
                    selected=homeFragment;
                }else if(pos==1){
                    selected= rankingFragment;
                }else if(pos==2){
                    selected=shoppingFragment;
                }else if(pos==3){

                }else if(pos==4){

                }else if(pos==5){

                }
                if(pos<3){
                    getSupportFragmentManager().beginTransaction().
                            replace(R.id.mainContainer,selected).commit();
                }
            }
        });


    }

    public void clickHomeImage(View view){
        Log.d("MainActivity","clickHomeImage");


    }

    public void clickShoppingImage(View view){
        Log.d("MainActivity","clickShoppingImage");
        Intent intent = new Intent(this,CategoryActivity.class);
        startActivity(intent);
    }

}
