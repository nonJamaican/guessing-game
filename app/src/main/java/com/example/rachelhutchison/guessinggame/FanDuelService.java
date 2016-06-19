package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FanDuelService {

    String BASE_URL = "https://cdn.rawgit.com";
    String GET_PLAYERS_DATA_URL = "/liamjdouglas/bb40ee8721f1a9313c22c6ea0851a105/raw/6b6fc89d55ebe4d9b05c1469349af33651d7e7f1/Player.json";

    @GET(GET_PLAYERS_DATA_URL)
    Call<FanDuelPlayers> getPlayerData();
}
