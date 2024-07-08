package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;


public class ChamadosAceitosController implements Initializable{
	@FXML
    private AnchorPane scrollBox;
	
	 public void initialize(URL location, ResourceBundle resources) {
		 
		 Chamado chamado = new Chamado(null, null, null, null);
		 chamado.chamadosAceitos(scrollBox);
	 }
}
