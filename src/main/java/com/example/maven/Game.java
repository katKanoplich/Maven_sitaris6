package com.example.maven;


public class Game {
    private String id;
    private String name;
    private String genre;
    private String platform;
    private int releaseYear;
    private String developer;
    private float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Game(String id,float price, String name, String genre, String platform, int releaseYear, String developer) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
        this.developer = developer;
    }
    public Game(){

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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    @Override
    public String toString() {
        return "Game[id:" + getId() + ", name: " + getName() + ", genre: " + getGenre() + ", platform: " + getPlatform() + ", releaseYear: " + getReleaseYear() + ", developer: "+getDeveloper()+"]";
    }

}