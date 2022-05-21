package com.example.finalproject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CharacterApi {

    @GET("characters")
        Call<List<CharacterItem>>getCharacter();

}
