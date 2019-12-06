package com.mple.matei.glumebune;

/**
 * Created by Matei on 11/30/2017.
 */

public class Postache {
    public String categorie, date, gluma, name,  titlu,user_id,id;
    public int score,real,spam;

    public long timp;
    public Postache() {

    }

    public Postache(String titlu, String date, String name, String gluma, String user_id,String categorie, int score,long timp,String id,int real,int spam) {
        this.date = date;
        this.titlu =titlu;
        this.name = name;
        this.gluma = gluma;
        this.score= score;
        this.user_id=user_id;
        this.categorie = categorie;
        this.timp=timp;
        this.id=id;
        this.real=real;
        this.spam=spam;

    }

    public void setReal(int real) {
        this.real = real;
    }

    public int getReal() {
        return real;
    }

    public void setSpam(int spam) {
        this.spam = spam;
    }

    public int getSpam() {
        return spam;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setTimp(long timp) {
        this.timp = timp;
    }

    public long getTimp() {
        return timp;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setGluma(String gluma) {
        this.gluma = gluma;
    }

    public String getGluma() {
        return gluma;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_id() {
        return user_id;
    }

}
