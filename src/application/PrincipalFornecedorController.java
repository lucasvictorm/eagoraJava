package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class PrincipalFornecedorController implements Initializable{
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
    	janela.novaJanela(btnServicosDisponiveis, "../gui/ServicosDisponiveis.fxml", "Serviços");
    	    	

    }
    
    public void initialize(URL location, ResourceBundle resources) {
        label_nome.setText(SessaoFornecedor.getInstance().getNome());
        
    }
    
    @FXML
    void logout(MouseEvent event) throws IOException {
    	
    	if(SessaoFornecedor.getInstance().getId()==null){
    		SessaoUsuario.getInstance().limparSessao();
    		
    	}else {
    		SessaoFornecedor.getInstance().limparSessao();
    	}
    	
    	janela.novaJanela(logoutBox, "../gui/Login.fxml", "Home");
    }

}
