package com.example.finalproject;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CharacterItem {
    private Integer char_id;
    private String name;
    private String birthday;
    private List<String> occupation;
    private String img;
    private String status;
    private String nickname;
    private List<Integer> appearance;
    private String portrayed;
    private String category;
    private List<Object> better_call_saul_appearance;

    public Integer getChar_id() {
        return char_id;
    }

    public String getName() {
        return name;
    }

    public String getBirthday() {
        return birthday;
    }

    public List<String> getOccupation() {
        return occupation;
    }

    public String getImg() {
        return img;
    }

    public String getStatus() {
        return status;
    }

    public String getNickname() {
        return nickname;
    }

    public List<Integer> getAppearance() {
        return appearance;
    }

    public String getPortrayed() {
        return portrayed;
    }

    public String getCategory() {
        return category;
    }

    public List<Object> getBetter_call_saul_appearance() {
        return better_call_saul_appearance;
    }
}
