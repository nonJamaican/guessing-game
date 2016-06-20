package com.example.rachelhutchison.guessinggame.api;

import com.example.rachelhutchison.guessinggame.model.FanDuelPlayers;

import org.junit.Before;
import org.junit.Test;

import retrofit2.Call;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class FanDuelServiceRequestTest {

    private static final String EXPECTED_PLAYERS_DATA_URL = "https://cdn.rawgit.com/liamjdouglas/bb40ee8721f1a9313c22c6ea0851a105/raw/6b6fc89d55ebe4d9b05c1469349af33651d7e7f1/Player.json";

    private FanDuelServiceRequest request;

    @Before
    public void setUp() {
        request = new FanDuelServiceRequest();
    }

    @Test
    public void getPlayersDataShouldHaveRequestCorrectUrl() {
        Call<FanDuelPlayers> fanDuelPlayersCall = request.makeGetPlayersDataRequest();
        assertEquals(EXPECTED_PLAYERS_DATA_URL, fanDuelPlayersCall.request().url().toString());
    }

    @Test
    public void getPlayersDataShouldRequestTypeGet() {
        Call<FanDuelPlayers> fanDuelPlayersCall = request.makeGetPlayersDataRequest();
        assertEquals("GET", fanDuelPlayersCall.request().method());
    }

    @Test
    public void getPlayersDataShouldHaveRequestBodyNull() {
        Call<FanDuelPlayers> fanDuelPlayersCall = request.makeGetPlayersDataRequest();
        assertNull(fanDuelPlayersCall.request().body());
    }
}
