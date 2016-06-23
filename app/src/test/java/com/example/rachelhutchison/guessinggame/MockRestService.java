package com.example.rachelhutchison.guessinggame;

import com.example.rachelhutchison.guessinggame.api.FanDuelService;
import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.mock.BehaviorDelegate;
import retrofit2.mock.Calls;
import retrofit2.mock.MockRetrofit;

public class MockRestService {

    public Call<FanDuelPlayers> getSuccessResponse = Calls.response(Response.success(new FanDuelPlayers()));
    public Call<FanDuelPlayers> getFailureResponse = Calls.failure(new IOException());

    public FanDuelService buildMockRestService(final Call<FanDuelPlayers> response) {
        final BehaviorDelegate<FanDuelService> delegate = getMockRetrofit().create(FanDuelService.class);

        return new FanDuelService() {

            @Override
            public Call<FanDuelPlayers> getFanDuelPlayerData() {
                return delegate.returning(response).getFanDuelPlayerData();
            }
        };
    }

    private MockRetrofit getMockRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.google.co.uk")
                .build();

        return new MockRetrofit
                .Builder(retrofit)
                .build();
    }
}


