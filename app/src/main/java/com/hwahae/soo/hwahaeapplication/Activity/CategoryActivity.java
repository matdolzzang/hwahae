package com.hwahae.soo.hwahaeapplication.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.Adapter.CategoryAdapter;
import com.hwahae.soo.hwahaeapplication.Fragment.PopupDialogFragment;
import com.hwahae.soo.hwahaeapplication.Model.CategoryModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class CategoryActivity extends BaseActivity{

    ImageView categoryDownDirection;
    boolean isOneTimePressed=false;
    DialogFragment popupDialogFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        categoryDownDirection= findViewById(R.id.categoryDownDirection);
        categoryDownDirection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isOneTimePressed){
                    categoryDownDirection.setImageDrawable(getDrawable(R.drawable.categorytopdirection));
                    isOneTimePressed=true;
                    popupDialogFragment= new PopupDialogFragment();
//                    Window dialogWindow = popupDialogFragment.getDialog().getWindow();
//                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//                dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
//                lp.x = 100; // The new position of the X coordinates
//                lp.y = 100; // The new position of the Y coordinates
//                lp.width = 300; // Width
//                lp.height = 300; // Height
//                lp.alpha = 0.7f; // Transparency
//                dialogWindow.setAttributes(lp);

                    popupDialogFragment.show(getSupportFragmentManager(),"PopupDialogFragment");


                }else{
                    popupDialogFragment.dismiss();
                    isOneTimePressed=false;
                    categoryDownDirection.setImageDrawable(getDrawable(R.drawable.downdirection));
                }

//                Window dialogWindow = dialogFragment.getDialog().getWindow();
//                WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//                dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
//                lp.x = 100; // The new position of the X coordinates
//                lp.y = 100; // The new position of the Y coordinates
//                lp.width = 300; // Width
//                lp.height = 300; // Height
//                lp.alpha = 0.7f; // Transparency
//                dialogWindow.setAttributes(lp);
//                //dialogFragment.show(getSupportFragmentManager(),"Popup");
            }
        });
    }

}
