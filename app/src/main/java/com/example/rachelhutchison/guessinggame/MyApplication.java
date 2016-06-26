package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.api.FanDuelService;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends android.app.Application {

    private FanDuelService restService;
    private Picasso imageService;

    public MyApplication() {
        super.onCreate();
        setRestService(getRetrofit().create(FanDuelService.class));
        setImageService(getPicasso());
    }

    public FanDuelService getRestService() {
        return restService;
    }

    public void setRestService(FanDuelService restService) {
        this.restService = restService;
    }

    private Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(FanDuelService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private Picasso getPicasso() {
        return getBaseContext() == null ? null : Picasso.with(getBaseContext());
    }

    public Picasso getImageService() {
        if (imageService == null) {
            setImageService(getPicasso());
        }
        return imageService;
    }

    public void setImageService(Picasso imageService) {
        this.imageService = imageService;
    }
}
