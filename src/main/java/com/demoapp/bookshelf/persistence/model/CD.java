package com.demoapp.bookshelf.persistence.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CD extends Item {

    @ElementCollection
    private List<String> tracks = new ArrayList<String>();

    public CD() {
    }

    public CD(List<String> tracks) {
        this.tracks = tracks;
    }

    public CD(String title) {
        super.setTitle(title);
    }

    public List<String> getTracks() {
        return tracks;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }
}
