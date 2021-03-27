package it.polito.tdp.alien;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

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
    	if(input.equals("")) {
    		txtResult.setText("Nessuna parola inserita");
    		return;
    	}
    	
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
    		
    	if(input.contains("?")) {
    		String parte1="";
    		String parte2="";
    		String[] v=input.split("\\?");
    		if(v.length>2) {
    			txtResult.setText("Spiacenti, è ammesso al massimo un ?");
    			return;
    		}
    		
    		if(input.indexOf("?")==(input.length()-1)) {
    			parte1=v[0];
    			parte2="";
    	
    		}else if(input.indexOf("?")==0) {
    			parte1="";
    			parte2=v[1];
    		}
    		else {
    			parte1=v[0];
    			parte2=v[1];
    		}
    	
    		if(!parte1.equals("")) {
    			if(parte1.matches("[a-zA-Z]+")==false ) {
    				txtResult.setText("ERRORE: gli unici caratteri ammessi sono: [a-zA-Z], al limite un ? ");
            		return;
    			}
    		}
    			
    		if(!parte2.equals("")) {
    			if(parte2.matches("[a-zA-Z]+")==false ) {
    				txtResult.setText("ERRORE: gli unici caratteri ammessi sono: [a-zA-Z], al limite un ? ");
            		return;
    			}
    		}
    			
    		
    		
    		
    		if(model.wildCard(parte1, parte2)==0) {
    			txtResult.setText("Hai inserito una parola con ?, ma questa"+ "\n"+ "non è contenuta nel dizionario");
    			return;
    		}
    		else if(model.wildCard(parte1, parte2)>1) {
    			txtResult.setText("Ci dispiace, ma a questa parola misteriosa corrisponde a più parole già salvate");
    			return;
    		}
    		else {
    			txtResult.setText("La parola misteriosa combacia con "+this.model.parolaMisteriosa(parte1, parte2)+" la traduzione è "+ this.model.traduci(this.model.parolaMisteriosa(parte1, parte2)));
    			return;
    		}
    	}
    			
    		
    		
    	if(input.matches("[a-zA-Z]+")==false) {
    		txtResult.setText("ERRORE: gli unici caratteri ammessi sono: [a-zA-Z] ");
    		return;
    	}
    	
    	
    	
    	Collection<String> traduzione=model.traduci(input);
    	if(traduzione==null) {
    		txtResult.setText("Questa parola non è ancora stata aggiunta, impossibile tradurla");
    		return;
    	}
    	txtResult.setText("La traduzione di "+input+" e' "+traduzione.toString());
    	
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
