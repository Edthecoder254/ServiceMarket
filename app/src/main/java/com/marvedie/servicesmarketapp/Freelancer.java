package com.marvedie.servicesmarketapp;

public class Freelancer {

    String freelancerid;
    String freelancerName;
    String freelancerGenre;

    //define constructor that will be used while Reading the Values

    public Freelancer(){


    }

    //New Constructor that will initialise our Strings


    public Freelancer(String freelancerid, String freelancerName, String freelancerGenre) {
        this.freelancerid = freelancerid;
        this.freelancerName = freelancerName;
        this.freelancerGenre = freelancerGenre;
    }

    public String getFreelancerid() {
        return freelancerid;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public String getFreelancerGenre() {
        return freelancerGenre;
    }
}
