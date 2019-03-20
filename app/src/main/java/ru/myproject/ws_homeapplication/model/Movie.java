package ru.myproject.ws_homeapplication.model;

import java.util.Comparator;

public class Movie {


    private String title;
    private int year;
    private float rating;
    private String plot;
    private String award;
    private String actor;
    private String website;
    private String poster;



    public Movie(String title, int year, String actor,String plot, String award,
                 String poster,String websitefloat,float rating) {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.plot = plot;
        this.poster = poster;
        this.award=award;
        this.actor=actor;
        this.website=website;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public static Comparator<Movie> sMovieComparator = new Comparator<Movie>() {

        @Override
        public int compare(Movie o1, Movie o2) {

            Float rating_movie1 = o1.getRating();
            Float rating_movie2 = o2.getRating();


            return rating_movie2.compareTo(rating_movie1);
        }
    };


}
