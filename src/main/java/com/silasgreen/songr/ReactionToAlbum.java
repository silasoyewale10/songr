package com.silasgreen.songr;

import javax.persistence.*;

@Entity
public class ReactionToAlbum {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    Album album;
    public String action;
    public int intensity;

    public ReactionToAlbum(){

    }
    public ReactionToAlbum(String action, int intensity){

        this.action = action;
        this.intensity = intensity;
    }
    public String toString(){
        return String.format("I feel %s this many : %d", action, intensity);
    }


}
