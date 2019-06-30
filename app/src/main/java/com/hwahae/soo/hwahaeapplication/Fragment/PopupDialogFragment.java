package com.hwahae.soo.hwahaeapplication.Fragment;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.hwahae.soo.hwahaeapplication.Activity.BrandRankingActivity;
import com.hwahae.soo.hwahaeapplication.Activity.CategoryActivity;
import com.hwahae.soo.hwahaeapplication.Adapter.CategoryAdapter;
import com.hwahae.soo.hwahaeapplication.Model.CategoryModel;
import com.hwahae.soo.hwahaeapplication.R;

import java.util.ArrayList;

public class PopupDialogFragment extends DialogFragment {
    GridView gridView;
    ArrayList<CategoryModel> models = new ArrayList<>();
    CategoryAdapter mainCategoryAdapter;
    ImageView image;
    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        image=getActivity().findViewById(R.id.categoryDownDirection);
        image.setImageDrawable(getActivity().getDrawable(R.drawable.downdirection));
    }
///3
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup= (ViewGroup) inflater.inflate(R.layout.popup_dialog,container,false);

        Window dialogWindow = getDialog().getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        dialogWindow.setGravity(Gravity.LEFT | Gravity.TOP);
        lp.x = 100; // The new position of the X coordinates
        lp.y = 140; // The new position of the Y coordinates
        lp.width = 300; // Width
        lp.height = 300; // Height
        lp.alpha = 0.7f; // Transparency
        dialogWindow.setAttributes(lp);

        return viewGroup;
    }

    public interface PopupDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    // Use this instance of the interface to deliver action events
    PopupDialogListener mListener;
    ///111
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryone)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorytwo)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorythree)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryfour)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categoryfive)));
        models.add(new CategoryModel(getActivity().getDrawable(R.drawable.categorysix)));
        mainCategoryAdapter= new CategoryAdapter();
        mainCategoryAdapter.addItems(models);
    }
///2
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final LayoutInflater inflater = getActivity().getLayoutInflater();

        View view=inflater.inflate(R.layout.popup_dialog,null);
        gridView = view.findViewById(R.id.PopupDialogGridView);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                Intent intent=new Intent();
                if(pos==0){
                    intent = new Intent(getActivity(),CategoryActivity.class);
                }else if(pos==1){
                    intent = new Intent(getActivity(),BrandRankingActivity.class);

                }else if(pos==2){

                }else if(pos==3){

                }else if(pos==4){

                }else if(pos==5){

                }
                if(intent!=null){
                    getActivity().startActivity(intent);
                }
            }
        });
        gridView.setAdapter(mainCategoryAdapter);
        builder.setView(view);

        return builder.create();
    }
}
