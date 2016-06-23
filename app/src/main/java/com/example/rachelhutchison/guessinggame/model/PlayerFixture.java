package com.example.rachelhutchison.guessinggame.model;

import java.io.Serializable;
import java.util.List;

public class PlayerFixture implements Serializable {
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
