package it.polito.tdp.alien;

import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Traduttore;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	 
	
	private AlienDictionary aliendictionary=new AlienDictionary();
	
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
    	this.aliendictionary.doReset();
    	txtResult.clear();
    	txtInput.clear();
    }

    @FXML
    void handleTranslation(ActionEvent event) {
    	txtResult.clear();
    	String riga=txtInput.getText();
    	
    	if(riga==null || riga.length()==0) {
    		txtResult.setText("Inserisci una o due parole");
    		return;
    	}
    	
    	StringTokenizer st=new StringTokenizer(riga," ");
    	if(!st.hasMoreTokens()) {
    		txtResult.setText("Inserisci una o due parole");
    		return;
    	}
    	String alienWord=st.nextToken();
    	if(st.hasMoreTokens()) {
    		String translation=st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*")|| !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("inserire solo caratteri alfabetici");
    			return;
    		}
    		
    		this.aliendictionary.addWord(alienWord, translation);
    		txtResult.setText("La parola \""+alienWord+"\"+ traduzione"+translation);
    		
    	}else {
    		if(!alienWord.matches("[a-zA-Z?]*")) {
    			txtResult.setText("inserire solo caratteri alfabetici");
    			return;
    		}
    		String translation;
    		//String translation=this.aliendictionary.translateWord(alienWord);
    	/*	if(translation!=null) {
    			txtResult.setText(translation);
    		}else {
    			txtResult.setText("La parola cercata non è presente nel dizionario");
    			
    		}*/
    		if(alienWord.matches("[a-zA-Z?]*") && !alienWord.matches("[a-zA-Z]*")) {
    		//vuol dire che è  in regola, ma ha punto interrogativo
    			translation=this.aliendictionary.translateWordWildCard(alienWord);
    		}
    		else {
    			translation=this.aliendictionary.translateWord(alienWord);
    		}
    		
    		if(translation!=null) {
    			txtResult.setText(translation);
    		}
    		else {
    			txtResult.setText("La parola cercata non è presente");
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtInput != null : "fx:id=\"txtInput\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
