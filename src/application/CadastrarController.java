package application;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class CadastrarController {

    @FXML
    private Button botaoEntrar;

    @FXML
    private Pane boxCategorias;

    @FXML
    private CheckBox eletricistaCheck;

    @FXML
    private CheckBox encanadorCheck;

    @FXML
    private CheckBox fornecedorCheck;

    @FXML
    private PasswordField inputSenha;

    @FXML
    private TextField loginInput;

    @FXML
    private TextField nomeInput;

    @FXML
    private CheckBox pedreiroCheck;

    @FXML
    void cadastrar(ActionEvent event) {
    	SessaoFornecedor fornecedor = new SessaoFornecedor();
    	
    	Janela janela = new Janela();
    	String login = loginInput.getText();
    	String nome = nomeInput.getText();
    	String senha = inputSenha.getText();
    	String sql = "";
    	
    	if(fornecedorCheck.isSelected()) {
    		sql = "insert into usuarios (nome, user, senha, tipo) values '"+nome+"', '"+login+"', '"+senha+"', '1'";
    	}else {
    		sql = "insert into usuarios (nome, user, senha, tipo) values '"+nome+"', '"+login+"', '"+senha+"', '0'";
    	}
    	
    	
    	Sql bd = new Sql();
    	String id = "";
    	
    	try {
    		
        	bd.conectar();
        	
        	
        	bd.insertQuery(sql);
        	ResultSet result = bd.fazerQuery("select id from usuarios where username='"+login+"'");
        	while(result.next()) {
        		 id = result.getString("id");
        	}
    	
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	if(fornecedorCheck.isSelected()) {
    		List<CheckBox> checkBoxes = new ArrayList<>();
        	checkBoxes.add(eletricistaCheck);
        	checkBoxes.add(encanadorCheck);
        	checkBoxes.add(pedreiroCheck);
        	
        	List<String> categoriasList = new ArrayList<>();
        	
        	for(CheckBox checkBox : checkBoxes) {
        		if(checkBox.isSelected()) {
        			categoriasList.add(checkBox.getText());
        		}else {
        			categoriasList.add(null);
        		}
        		
        		
        	}
    		fornecedor.setCategorias(categoriasList);
    		
    		sql = "insert into fornecedores (id_user, cat1, cat2, cat3) values '"+id+"', '"+categoriasList.get(0)+"', '"+categoriasList.get(1)+"', '"+categoriasList.get(2)+"'";
    		
    		bd.insertQuery(sql);
    		
    		
    		try {
    			janela.novaJanela(botaoEntrar, "../gui/MenuPrestadorServiço", "Menu");
    		}catch (Exception e) {
				// TODO: handle exception
			}
    		
    	}else {
    		try {
    			janela.novaJanela(botaoEntrar, "../gui/MenuPrincipal", "Menu");
    		}catch (Exception e) {
				// TODO: handle exception
			}
    		
    	}
    	
    	
    }

}
