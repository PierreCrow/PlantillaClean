package pe.com.plantilla.presentation.utils;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class FbAnalitycs {

    private FirebaseAnalytics mFirebaseAnalytics;

    void connect(Context context)
    {
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }


}
