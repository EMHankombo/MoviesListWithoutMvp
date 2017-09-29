package com.example.mainza1992.movieapi.services;

import com.example.mainza1992.movieapi.API_Constants;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mainza1992 on 28/09/2017.
 */

public class ConnectionService {

    static Retrofit retrofit;
    static OkHttpClient okHttpClient;

    public static IRequestInterface getConnectionService(){
        // okHttpClient = buildClient();
        retrofit = new Retrofit.Builder()
                .baseUrl(API_Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                // .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(IRequestInterface.class);
    }
}
