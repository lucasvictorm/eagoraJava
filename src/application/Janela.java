package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Janela{
	public void novaJanela(Button botao, String caminho, String titulo) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource(caminho));
	    Parent root = loader.load();
	    Stage stage = new Stage();
	    stage.setScene(new Scene(root));
	    stage.setTitle(titulo);
	    stage.show();
	    
	    Stage primaryStage = (Stage) botao.getScene().getWindow();
	    
        primaryStage.close();
	    /*Stage primaryStage = (Stage) botao.getScene().getWindow();
	    
	    primaryStage.close();*/
	}
}
