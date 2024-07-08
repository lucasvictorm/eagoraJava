package application;

import java.io.IOException;



import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class CabecalhoController {
	Janela janela = new Janela();
	
	
	@FXML
    private ImageView homeBox;

    @FXML
    private Pane logoutBox;

    @FXML
    void home(MouseEvent event) throws IOException {
    	if(SessaoFornecedor.getInstance().getId() == null){
    		janela.novaJanela(homeBox, "../gui/MenuPrincipal.fxml", "Home");
    	}else {
    		janela.novaJanela(homeBox, "../gui/MenuPrestadorServiço.fxml", "Home");
    	}
    	
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
