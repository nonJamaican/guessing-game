package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.api.FanDuelService;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends android.app.Application {

    private FanDuelService service;
    private Picasso imageService;

    public MyApplication() {
        super.onCreate();
        setService(getRetrofit().create(FanDuelService.class));
        setImageService(getPicasso());
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

    private Picasso getPicasso() {
        if (getBaseContext() == null) {
            return null;
        }
        return Picasso.with(getBaseContext());
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
