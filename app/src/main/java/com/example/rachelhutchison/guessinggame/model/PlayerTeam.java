package com.example.rachelhutchison.guessinggame.model;

import java.util.List;

public class PlayerTeam {

    private List<String> members;
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
