package pe.com.plantilla.presentation.ui.activities;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.facebook.stetho.Stetho;
import pe.com.plantilla.presentation.utils.ExceptionHandler;


import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   Stetho.initializeWithDefaults(this);
       // hideKeyboard(this);
        // getUnhandledExceptions();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }



    protected void next(Class<?> activity) {
        Intent intent = new Intent(getApplicationContext(), activity);
        startActivity(intent);
    }


    protected void getUnhandledExceptions() {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler(this, BaseActivity.class));
    }


    protected void injectView() {
        ButterKnife.bind(this);
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    void askPermisions(Activity ctx) {

        int PERMISSION_ALL = 1;
        String[] PERMISSIONS = {
                Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
        };

        if (!hasPermissions(ctx, PERMISSIONS)) {
            ActivityCompat.requestPermissions(ctx, PERMISSIONS, PERMISSION_ALL);
        }
    }




}
