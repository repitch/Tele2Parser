package com.repitch.tele2parser.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.joda.time.DateTime;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by repitch on 08.11.2017.
 */
public class ApiManager {

    public static final String BASE_URL = "https://msk.shop.tele2.ru";

    private static ApiManager instance;
    private Retrofit retrofit;

    public static void init(Context context) {
        instance = new ApiManager();
    }

    public static ApiManager getInstance() {
        if (instance == null) {
            throw new IllegalStateException("ApiManager must be initiated before calling getInstance()");
        }
        return instance;
    }

    public ApiManager() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(chain -> {
                    Request request = chain.request();
                    request = request.newBuilder()
                            .header("ARRAffinity_eshop", "fccfcd64719433f875eada13334333788a614db9ab5c00cc1cf628958018196a")
                            .header("Tele2Token", "1d7d1086-3031-4c63-9192-5d8e6c3b547d")
                            .build();
                    return chain.proceed(request);
                })
                .addInterceptor(new LoggingInterceptor())
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(getBaseUrl())
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(createGson()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public String getBaseUrl() {
        return BASE_URL;
    }

    public ApiService getApiService() {
        return retrofit.create(ApiService.class);
    }

    private Gson createGson() {
        final GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(DateTime.class, DateTimeDeserializer.INSTANCE);
        return builder.create();
    }

}
