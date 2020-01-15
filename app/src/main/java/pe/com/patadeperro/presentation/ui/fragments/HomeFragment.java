package pe.com.patadeperro.presentation.ui.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.com.patadeperro.R;
import pe.com.patadeperro.presentation.ui.dialogfragment.LostDetail;


public class HomeFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View x = inflater.inflate(R.layout.home_fragment, null);

        return x;

    }


    void loadLostDialogFragment() {
        Bundle bundle = new Bundle();
        bundle.getString("key", "value");
        LostDetail df = new LostDetail();
        df.setArguments(bundle);
        df.show(getFragmentManager(), "ClientDetail");
    }


    void loadAccuntFragment() {

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_up, R.anim.slide_out_down);
        AccountFragment accountFragment = new AccountFragment();
        fragmentTransaction.replace(R.id.containerView, accountFragment);
        fragmentTransaction.commit();

    }


    public interface interfacePrueba {
        public void pruebaInterface();
    }


    void sendCallback() {
        Activity ahhh = getActivity();

        if (ahhh instanceof interfacePrueba) {
            ((interfacePrueba) ahhh).pruebaInterface();
        }

    }


}