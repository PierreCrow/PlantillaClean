package com.avances.applima.presentation.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.stetho.Stetho;
import com.avances.applima.presentation.utils.ExceptionHandler;


import butterknife.ButterKnife;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        hideKeyboard(this);
       // getUnhandledExceptions();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


    }


    protected void hideKeyboard(Activity act) {
        act.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
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
}
