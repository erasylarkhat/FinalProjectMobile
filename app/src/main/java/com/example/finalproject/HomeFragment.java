package com.example.finalproject;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {


    RecyclerView recyclerView;
    List<CharacterItem> characterItemList;
    TextView countText ;
    


    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_character, container,false);


        recyclerView = view.findViewById(R.id.recyclerView);
        characterItemList = new ArrayList<>();

        countText = view.findViewById(R.id.size);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.breakingbadapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CharacterApi charactersPlaceHolderApi = retrofit.create(CharacterApi.class);

        Call<List<CharacterItem>> call = charactersPlaceHolderApi.getCharacter();

        call.enqueue(new Callback<List<CharacterItem>>() {
            @Override
            public void onResponse(Call<List<CharacterItem>> call, Response<List<CharacterItem>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<CharacterItem> charactes = response.body();
                for (CharacterItem i :charactes){
                    characterItemList.add(i);
                }

                PutDataIntoRecyclerView(characterItemList);

                System.out.println("#######################3");
            }

            @Override
            public void onFailure(Call<List<CharacterItem>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });
        return view;
    }

    private void PutDataIntoRecyclerView(List<CharacterItem> characterItemList) {

        Adapter adapter = new Adapter(getLayoutInflater().getContext(),characterItemList);

        countText.setText(adapter.getItemCount()+" characters");
        recyclerView.setLayoutManager(new LinearLayoutManager(getLayoutInflater().getContext()));
        recyclerView.setAdapter(adapter);


        adapter.setOnItemClickListener(new Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int possition) {
                Intent intent = new Intent(getLayoutInflater().getContext(),ClicketItem.class);
                intent.putExtra("name",characterItemList.get(possition).getName());
                intent.putExtra("birth",characterItemList.get(possition).getBirthday());
                intent.putExtra("img",characterItemList.get(possition).getImg());
                intent.putExtra("status",characterItemList.get(possition).getStatus());
                startActivity(intent);
            }
        });
    }
}
