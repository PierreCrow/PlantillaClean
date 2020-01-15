package pe.com.patadeperro.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.com.patadeperro.R;

public class LostFragment extends BaseFragment implements
        View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View x = inflater.inflate(R.layout.lost_fragment, null);


        return x;

    }


    @Override
    public void onClick(View view) {

    }


    @Override
    public void onPause() {
        super.onPause();

    }


}
