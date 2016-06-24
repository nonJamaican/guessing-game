package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Team implements Serializable {
    private String city;
    private String code;
    @SerializedName("full_name")
    private String fullName;
    private String id;
    private String name;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
