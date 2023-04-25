package com.example.activite7.model;

import java.io.Serializable;

//Serializable : interface
// - processus de serialisation  -
// il faut marquer les objets  comme serialisable (implements serializiable)

public class City implements Serializable {
    private String name; //la convension
    private String country;
    private long habitant;
    private int imageId;//les images sont stockées dans le dossier drawable
    private int smalldesc;
    private int fulldesc;
    private int site;

    public City() {
    }

    public City(String name, String country, long habitant, int imageId, int smalldesc, int fulldesc, int site) {
        this.name = name;
        this.country = country;
        this.habitant = habitant;
        this.imageId = imageId;
        this.smalldesc = smalldesc;
        this.fulldesc = fulldesc;
        this.site = site;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public long getHabitant() {
        return habitant;
    }

    public void setHabitant(long habitant) {
        this.habitant = habitant;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getSmalldesc() {
        return smalldesc;
    }

    public void setSmalldesc(int smalldesc) {
        this.smalldesc = smalldesc;
    }

    public int getFulldesc() {
        return fulldesc;
    }

    public void setFulldesc(int fulldesc) {
        this.fulldesc = fulldesc;
    }

    public int getSite() {
        return site;
    }

    public void setSite(int site) {
        this.site = site;
    }
}
