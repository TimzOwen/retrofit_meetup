package com.owen.retrofit_meetup;

public class Heroes {
    //create Strings that will hold the json objects to java classes
    private String name;
    private String realname;
    private String team;
    private String firstappearance;
    private String createdby;
    private String publisher;
    private String imgurl;
    private String bio;

    public Heroes(String name, String realname, String team, String firstappearance, String createdby, String publisher, String imgurl, String bio) {
        this.name = name;
        this.realname = realname;
        this.team = team;
        this.firstappearance = firstappearance;
        this.createdby = createdby;
        this.publisher = publisher;
        this.imgurl = imgurl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealname() {
        return realname;
    }

    public String getTeam() {
        return team;
    }

    public String getFirstappearance() {
        return firstappearance;
    }

    public String getCreatedby() {
        return createdby;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImgurl() {
        return imgurl;
    }

    public String getBio() {
        return bio;
    }
}
