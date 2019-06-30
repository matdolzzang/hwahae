package com.hwahae.soo.hwahaeapplication.Fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.Activity.EventActivity;
import com.hwahae.soo.hwahaeapplication.Activity.MainActivity;
import com.hwahae.soo.hwahaeapplication.R;

public class MainPopupDialogFragment extends DialogFragment {

    ImageView mainPopupImageX;
    ImageView mainPopupImage;
    ImageButton mainPopupEventButton;
    CheckBox mainPopupCheckBox;
    ///maybe this will be saved at db
    boolean isNotSeenEver=false;

    //1
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //2
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater= getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.main_popup_dialog,null);
        view.findViewById(R.id.MainPopupX).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        view.findViewById(R.id.MainPopupBox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getActivity(),EventActivity.class);
                getActivity().startActivity(intent);
            }
        });
        mainPopupCheckBox= view.findViewById(R.id.MainPopupCheckbox);
        mainPopupCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    isNotSeenEver=true;
                    getDialog().dismiss();
                }else{
                    isNotSeenEver=false;
                }
            }
        });

        builder.setView(view);
        return builder.create();
    }

    //3
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup)inflater.inflate(R.layout.main_popup_dialog,container,
                false);
        return viewGroup;
    }

    //4
    @Override
    public void dismiss() {
        super.dismiss();
    }
}
