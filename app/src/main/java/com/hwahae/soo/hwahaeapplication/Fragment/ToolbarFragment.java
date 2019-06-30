package com.hwahae.soo.hwahaeapplication.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.R;

public class ToolbarFragment extends Fragment {
    ImageView homeImage;
    HomeFragment homeFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.toolbar,container,false);
        homeImage= viewGroup.findViewById(R.id.logo_nav);
        homeFragment= new HomeFragment();

        homeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().
                        replace(R.id.mainContainer,homeFragment).commit();
            }
        });
        return viewGroup;

    }

}
