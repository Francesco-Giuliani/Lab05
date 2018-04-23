package it.polito.tdp.anagrammi.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.modello.Anagramma;
import it.polito.tdp.anagrammi.modello.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AnagrammiController {

	private Model model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcola;

    @FXML
    private TextArea txtAnagrammiCorretti;

    @FXML
    private TextArea txtAnagrammiErrati;

    @FXML
    private Button btnReset;

    @FXML
    void doCalcolaAnagrammi(ActionEvent event) { 
    	String parola = this.txtParola.getText();

    	if(parola.isEmpty() || parola == null) {
    		//TODO ECCEZIONE Errore
    		this.txtAnagrammiCorretti.appendText("Parola non valida. Inserire una parola.");
    		return;
    	}
    	
    	this.model.generaAnagrammi(parola);
    	
    	List<Anagramma> anagrammiCorretti = new ArrayList<>(this.model.getAnagrammiCorretti());
    	List<Anagramma> anagrammiErrati = new ArrayList<>(this.model.getAnagrammiErrati());
    	
    	for(Anagramma a : anagrammiCorretti)
    		this.txtAnagrammiCorretti.appendText(a.toString()+"\n");
    	
    	for(Anagramma a : anagrammiErrati)
    		this.txtAnagrammiErrati.appendText(a.toString()+"\n");

    	if(anagrammiCorretti.isEmpty())
    		this.txtAnagrammiCorretti.appendText("Nessun anagramma corretto.");
       	if(anagrammiErrati.isEmpty()) 
    		this.txtAnagrammiErrati.appendText("Nessun anagramma errato.");
       	
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtParola.clear();
    	this.txtAnagrammiCorretti.clear();
    	this.txtAnagrammiErrati.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnCalcola != null : "fx:id=\"btnCalcola\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiCorretti != null : "fx:id=\"txtAnagrammiCorretti\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert txtAnagrammiErrati != null : "fx:id=\"txtAnagrammiErrati\" was not injected: check your FXML file 'Anagrammi.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Anagrammi.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	//TODO eventuali altre operazioni
    }
}
