package com.example.rachelhutchison.guessinggame.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class PlayerTeam implements Serializable {

    @SerializedName("_members")
    private List<String> members;
    @SerializedName("_ref")
    private String ref;

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}
