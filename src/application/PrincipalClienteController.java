package application;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
	

public class PrincipalClienteController implements Initializable {
	Janela janela = new Janela();
    @FXML
    private Button btnEditarPerfil;

    @FXML
    private Label label_nome;

    @FXML
    private Button btnMeusChamados;

    @FXML
    private Button btnNovoChamado;
    
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
	
	public void editarPerfil() {
    	
	}
	
	

}


