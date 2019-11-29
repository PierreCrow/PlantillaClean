package com.avances.applima.data.datasource.cloud.apiclient;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static ApiClientInterface apiClientInterface;

    public static ApiClientInterface getInstagramService() {
        return new Retrofit.Builder()
                .baseUrl("")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(ApiClientInterface.class);
    }

    public static ApiClientInterface getApiClient() {
        Gson gson = new GsonBuilder().serializeNulls().create();
        if (apiClientInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    // .baseUrl(BuildConfig.HOST)
                    .client(getClient())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            apiClientInterface = retrofit.create(ApiClientInterface.class);
        }
        return apiClientInterface;
    }

    private static OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.MINUTES)
                .readTimeout(10, TimeUnit.MINUTES)
                .addInterceptor(logging)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
        return client;
    }
}
