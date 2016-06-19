package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FanDuelServiceRequest {

    private FanDuelService service;

    public FanDuelServiceRequest() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FanDuelService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(FanDuelService.class);

    }

    public Call<FanDuelPlayers> makeGetPlayersDataRequest() {
        return service.getPlayerData();
    }

}