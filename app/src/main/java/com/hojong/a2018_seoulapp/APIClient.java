package com.hojong.a2018_seoulapp;

import retrofit2.Retrofit;

public class APIClient {
    static Retrofit getClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .build();

        return retrofit;
    }
}
