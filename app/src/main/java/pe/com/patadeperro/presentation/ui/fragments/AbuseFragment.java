package pe.com.patadeperro.presentation.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.com.patadeperro.R;

public class AbuseFragment extends BaseFragment implements
        View.OnClickListener {


    RecyclerView rv_imperdibles;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View x = inflater.inflate(R.layout.abuse_fragment, null);

        initUI(x);

        return x;

    }


    void initUI(View v) {

       // rv_imperdibles = (RecyclerView) v.findViewById(R.id.rv_eventos);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.llEditarPerfil:
                // next(EditProfileActivity.class,getContext(),null);
                break;
            case R.id.llPreferencias:

                break;
            case R.id.llValoraApp:

                break;
            case R.id.llCerrarSesion:

                break;

        }
    }


    @Override
    public void onPause() {
        super.onPause();

    }


}
