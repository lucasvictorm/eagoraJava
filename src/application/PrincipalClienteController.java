package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
	

public class PrincipalClienteController implements Initializable {
	Janela janela = new Janela();

    @FXML
    private Label label_nome;

    @FXML
    private Button btnMeusChamados;

    @FXML
    private Button btnNovoChamado;
    
    @FXML
    private Pane logoutBox;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        label_nome.setText(SessaoUsuario.getInstance().getNome());
        
    }
    
    
    public void novoChamado() throws IOException {
    	try {
    		
        	janela.novaJanela(btnNovoChamado, "../gui/novoChamado.fxml", "Novo Chamado");
    	}catch (IOException e) {
			// TODO: handle exception
		}
    	
    	
    }
    
	public void meusChamados() throws IOException {
		try {
			janela.novaJanela(btnMeusChamados, "../gui/ChamadosCliente.fxml", "Novo Chamado");
		}catch (IOException e) {
			// TODO: handle exception
			System.out.println("Erro");
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


