package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PrincipalFornecedorController {
	Janela janela = new Janela();
    @FXML
    private Button btnEditarPerfil;

    @FXML
    private Button btnServicos;

    @FXML
    private Button btnServicosDisponiveis;

    @FXML
    private Label label_nome;

    @FXML
    void editarPerfil(ActionEvent event) {

    }

    @FXML
    void servicosAceitos(ActionEvent event) {

    }

    @FXML
    void verServicosDisponiveis(ActionEvent event) throws IOException {
    	janela.novaJanela(btnServicosDisponiveis, "../gui/ServicosDisponiveis", "Serviços");
    	
    	
    }

}
