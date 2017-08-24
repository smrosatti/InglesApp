/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smr.inglesapp.view;

import br.com.smr.inglesapp.model.Phrase;
import br.com.smr.inglesapp.model.Place;
import br.com.smr.inglesapp.model.repository.Dal;

/**
 *
 * @author SARA
 */
public class Insert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Dal dal = new Dal();
        
        Place p = new Place("Hotel");
        dal.create(p);
        
        dal = new Dal();
        
        Phrase pr = new Phrase("Hi!", "Oi", p);
        dal.create(pr);
        
    }
    
}
