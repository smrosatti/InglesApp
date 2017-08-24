/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smr.inglesapp.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author SARA
 */
@Entity
public class Phrase implements Model, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPhrase;
    private String phrase;
    private String translated;
    private byte[] audio;
    @OneToOne (cascade = {CascadeType.REFRESH, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Place place;

    public Phrase() {
    }

    public Phrase(String phrase, String translated, Place place) {
        this.phrase = phrase;
        this.translated = translated;
        this.place = place;
    }
    
    

    public Phrase(int idPhrase, String phrase, String translated, byte[] audio, Place place) {
        this.idPhrase = idPhrase;
        this.phrase = phrase;
        this.translated = translated;
        this.audio = audio;
        this.place = place;
    }
    
    
    public String getTranslated() {
        return translated;
    }

    public void setTranslated(String translated) {
        this.translated = translated;
    }

   
    public int getIdPhrase() {
        return idPhrase;
    }

    public void setIdPhrase(int idPhrase) {
        this.idPhrase = idPhrase;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public byte[] getAudio() {
        return audio;
    }

    public void setAudio(byte[] audio) {
        this.audio = audio;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }
    
    @Override
    public String toString(){
        return translated +" - "+ phrase;
    }
    
    
}
