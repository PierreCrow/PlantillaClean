package pe.com.patadeperro.presentation.ui.activities;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.com.patadeperro.R;
import pe.com.patadeperro.presentation.ui.dialogfragment.FilterDialog;
import pe.com.patadeperro.presentation.ui.fragments.TabHome;

public class MainActivity extends BaseActivity implements
        FilterDialog.CierraDialogFilter {


    FrameLayout containerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        loadTabHomeFragment();

    }

    private void initUI() {

        containerView = (FrameLayout) findViewById(R.id.containerView);

        loadTabHomeFragment();

    }


    void loadTabHomeFragment() {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // fragmentTransaction.setCustomAnimations(R.anim.slide_up_down, R.anim.slide_bottom);
        TabHome homeFragment = new TabHome();
        fragmentTransaction.replace(R.id.containerView, homeFragment);
        fragmentTransaction.commit();
    }


    @Override
    public void onClose_Filter(Boolean close) {

    }


}
