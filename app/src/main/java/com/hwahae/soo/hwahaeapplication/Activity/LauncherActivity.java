package com.hwahae.soo.hwahaeapplication.Activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.R;

public class LauncherActivity extends BaseActivity {

    ImageView launcherImage;
    AnimationDrawable launcherAnimation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.launcher_activity);
        launcherImage= findViewById(R.id.launcherOne);
        launcherImage.setImageDrawable(getDrawable(R.drawable.laucherone));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressON("Loading");
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        },3000);


        /*launcherImage.setImageDrawable(getDrawable(R.drawable.launcher_drawable_animation));
        launcherAnimation= (AnimationDrawable) launcherImage.getDrawable();

        launcherImage.post(new Runnable() {
            @Override
            public void run() {
                launcherAnimation.start();
                Intent intent= new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);

            }
        });
        */


    }
}
