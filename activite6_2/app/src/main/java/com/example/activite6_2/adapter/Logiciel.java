package com.example.activite6_2.adapter;

public class Logiciel {

    private String nom;
    private String desc;
    private int resImage;

    public Logiciel(String nom, String desc, int resImage) {
        this.nom = nom;
        this.desc = desc;
        this.resImage = resImage;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public int getResImage() {
        return resImage;
    }
    public void setResImage(int resImage) {
        this.resImage = resImage;
    }
}
