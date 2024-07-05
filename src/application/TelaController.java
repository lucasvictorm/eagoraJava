package application;


import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    	String query = "select nome, id, tipo from usuarios where user='"+login+"' and senha='"+senha+"'";
    	
    	
    	try {
    		
    		ResultSet result = sql.fazerQuery(query);
    		if(result.next()) {
        		do {
        			System.out.println("Logado");
        			Janela janela = new Janela();
        			
        			String tipo = result.getString("tipo");
        			
        			if(tipo.equals("0")) {
        				SessaoUsuario.getInstance().setId(result.getString("id"));
            			SessaoUsuario.getInstance().setNome(result.getString("nome"));
        				janela.novaJanela(botaoEntrar, "../gui/MenuPrincipal.fxml", "Menu Principal");
        			}else {
        				System.out.println("Fornecedor");
        				List<String> categoriasArray = new ArrayList<>();
        				try {
        					String cate = "select cat1, cat2, cat3 from fornecedor where id_user='"+result.getString("id")+"'";
            				
            				ResultSet resultCat = sql.fazerQuery(cate);
            				System.out.println("kkk");
            				while(resultCat.next()) {
            					String cat1 = resultCat.getString("cat1");
            					String cat2 = resultCat.getString("cat2");
            					String cat3 = resultCat.getString("cat3");
            					
            					if(!cat1.equals("null")) {
            						categoriasArray.add(cat1);
            					}else {
            						categoriasArray.add(null);
            					}
            					
            					if(!cat2.equals("null")) {
            						categoriasArray.add(cat2);
            					}else {
            						categoriasArray.add(null);
            					}
            					
            					if(!cat3.equals("null")) {
            						categoriasArray.add(cat3);
            					}else {
            						categoriasArray.add(null);
            					}
            				
            				}
        				}catch (Exception e) {
							// TODO: handle exception
        					
						}
        				
        				
        				SessaoFornecedor.getInstance().setCategorias(categoriasArray);
        				List<String> lista =SessaoFornecedor.getInstance().getCategorias();
        				System.out.println(lista);
        				SessaoFornecedor.getInstance().setId(result.getString("id"));
            			SessaoFornecedor.getInstance().setNome(result.getString("nome"));
            			System.out.println("Antes");
        				janela.novaJanela(botaoEntrar, "../gui/MenuPrestadorServiço.fxml", "Menu Principal");
        				System.out.println("Passou");
        			}
        			
        			
        		}while(result.next());
        	}else {
        		System.out.println("Incorreto");
        	}
    	}catch (SQLException e) {
			// TODO: handle exception
    		System.out.println(e);
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
