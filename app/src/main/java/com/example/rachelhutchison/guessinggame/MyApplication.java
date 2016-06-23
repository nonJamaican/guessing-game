package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.api.FanDuelService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends android.app.Application {

    private FanDuelService service;

    public MyApplication() {
        super.onCreate();
        setService(getRetrofit().create(FanDuelService.class));
    }

    public FanDuelService getRestService() {
        return service;
    }

    public void setService(FanDuelService service) {
        this.service = service;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(FanDuelService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
}
