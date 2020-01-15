package pe.com.patadeperro.presentation.ui.fragments;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;

import com.com.patadeperro.R;

public class AccountFragment extends BaseFragment{






    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View x = inflater.inflate(R.layout.account_fragment, null);

        return x;

    }

}
