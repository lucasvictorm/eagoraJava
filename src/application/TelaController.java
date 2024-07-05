package application;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class TelaController {
    
	@FXML
    private PasswordField inputSenha;

    @FXML
    private TextField loginInput;
    
    @FXML
    private Button btnCadastro;

    @FXML
    private Button botaoEntrar;

    @FXML
    void fazerLogin() throws IOException {
    	Sql sql = new Sql();
    	sql.conectar();
    	
    	String login = loginInput.getText();  
    	String senha = inputSenha.getText();
    	String query = "select nome, id from usuarios where user='"+login+"' and senha='"+senha+"'";
    	
    	
    	try {
    		
    		ResultSet result = sql.fazerQuery(query);
    		if(result.next()) {
        		do {
        			System.out.println("Logado");
        			Janela janela = new Janela();
        			SessaoUsuario.getInstance().setId(result.getString("id"));
        			SessaoUsuario.getInstance().setNome(result.getString("nome"));
        			janela.novaJanela(botaoEntrar, "../gui/MenuPrincipal.fxml", "Menu Principal");
        			
        		}while(result.next());
        	}else {
        		System.out.println("Incorreto");
        	}
    	}catch (SQLException e) {
			// TODO: handle exception
		}
    	
    	
    
    	
    }
    @FXML
    void cadastrar() {
    	Janela janela = new Janela();
    	try {
    		janela.novaJanela(btnCadastro, "../gui/Cadastrar.fxml", "Cadastro");
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    }
}
