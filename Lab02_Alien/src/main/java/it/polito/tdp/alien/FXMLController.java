package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Traduttore model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnClear;

    @FXML
    void handleClear(ActionEvent event) {
    	txtResult.clear();
    	txtInput.clear();
    }

    @FXML
    void handleTranslation(ActionEvent event) {
    	String input= txtInput.getText().toLowerCase();
    	if(input.contains(" ")) {
    		String parolaA=input.substring(0, input.indexOf(" "));
    		String parolaU=input.substring(input.indexOf(" ")+1);
    		if(parolaA.matches("[a-zA-Z]+")==false || parolaU.matches("[a-zA-Z]+")==false) {
    			txtResult.setText("ERRORE: gli unici caratteri ammessi sono: [a-zA-Z] ");
        		return;
    		}	
    		
    		model.aggiungiParola(parolaA, parolaU);
    	}
    	else {
    	if(input.matches("[a-zA-Z]+")==false) {
    		txtResult.setText("ERRORE: gli unici caratteri ammessi sono: [a-zA-Z] ");
    		return;
    	}
    	
    	String traduzione=model.traduci(input);
    	
    	txtResult.setText("La traduzione di "+input+" e' "+traduzione);
    	}

    }
    
    public void setModel(Traduttore model) {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
