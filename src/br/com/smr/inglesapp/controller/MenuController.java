/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smr.inglesapp.controller;

import br.com.smr.inglesapp.model.Phrase;
import br.com.smr.inglesapp.model.repository.Dal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;



/**
 * FXML Controller class
 *
 * @author SARA
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btplay;

    @FXML
    private Label port;
    
    @FXML
    private ListView<Phrase> list;

    @FXML
    private Label eng;
    
    private Phrase selected;

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initlist();
        updateItem();
    }
    
    public void clear(){
        try {
           eng.setText(null);
           port.setText(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     public void updateItem() {
        list.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Phrase>() {
            @Override
            public void changed(ObservableValue<? extends Phrase> observable, Phrase oldValue, Phrase newValue) {
                selected = newValue;
                if (selected != null) {
                    eng.setText(selected.getPhrase());
                    port.setText(selected.getTranslated());
                } else {
                    clear();
                }
            }
        });
    }

    public void initlist(){
        try {
            
            Dal dal = new Dal();
            ObservableList<Phrase> phrases = FXCollections.observableArrayList(dal.getPhrase(1));
            
            list.setItems(phrases);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
