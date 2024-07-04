package application;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NovoChamadoController implements Initializable{
	 @FXML
    private Button bntLimpar;

    @FXML
    private Button btnEnviar;


    @FXML
    private TextArea labelDescricao;

    @FXML
    private TextField labelEndereco;

	@FXML
    private ComboBox<String> categorias_box;
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		//categorias_box.getItems().removeAll(categorias_box.getItems());
        categorias_box.getItems().addAll("Encanador", "Pedreiro", "Eletricista");
        
        
    }



    @FXML
    void enviarChamado(ActionEvent event) {
    	
    	String endereco = labelEndereco.getText();
    	String descricao = labelDescricao.getText();
    	String categoria = categorias_box.getSelectionModel().getSelectedItem().toString();
    	String id = SessaoUsuario.getInstance().getId();
    	
    	
    	
    	Chamado chamado = new Chamado(descricao, categoria, endereco , id);
    	
    	chamado.abrirChamado();
    	
    	
    }

    @FXML
    void limparChamado(ActionEvent event) {
    	categorias_box.getSelectionModel().clearSelection();
    	labelDescricao.setText("");
    	labelEndereco.setText("");
    	
    }


}
