package com.silasgreen.songr;

public class Album {
    private String title;
    private String artist;
    private int lengthInSeconds;
    private String imageUrl;   // this serves as the link to the album

    public Album(String title, String artist, int songCount, int lengthInSeconds, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.songCount = songCount;
        this.lengthInSeconds = lengthInSeconds;
        this.imageUrl = imageUrl;
    }

    public String toString(){
        return String.format("Title of Album: %s/n" +
                            "Name of Artist: %s /n"  +
                            "Song count of Artist : %d /n " +
                            "Duration : %d seconds " +
                            "URL to album : %s ", this.title, this.artist, this.songCount, this.lengthInSeconds, imageUrl);
    }

    //my setters
    public void setTitle(String title) {
        this.title = title;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }
    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }
    public void setLengthInSeconds(int lengthInSeconds) {
        this.lengthInSeconds = lengthInSeconds;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    //my getters
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return this.artist;
    }
    public int getSongCount() {
        return songCount;
    }
    private int songCount;

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }
    public String getImageUrl() {
        return imageUrl;
    }
}