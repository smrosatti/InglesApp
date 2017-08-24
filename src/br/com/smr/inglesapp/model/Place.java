/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smr.inglesapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author SARA
 */
@Entity
public class Place implements Model, Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlace;
    private String place;
    @OneToMany (targetEntity = Phrase.class, mappedBy = "place", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    private ArrayList<Phrase> phrases;

    public Place() {
    }

    public Place(String place) {
        this.place = place;
    }

    public Place(int idPlace, String place, ArrayList<Phrase> phrases) {
        this.idPlace = idPlace;
        this.place = place;
        this.phrases = phrases;
    }

    public Place(int idPlace, String place) {
        this.idPlace = idPlace;
        this.place = place;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }

    public void setPhrases(ArrayList<Phrase> phrases) {
        this.phrases = phrases;
    }

    public int getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(int idPlace) {
        this.idPlace = idPlace;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }
    
    
}
