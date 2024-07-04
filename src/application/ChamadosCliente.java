package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ChamadosCliente implements Initializable{

    @FXML
    private AnchorPane scrollBox;
    /*
    @FXML
    private Pane boxChamado;
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // label_nome.setText(SessaoUsuario.getInstance().getNome());
    	Pane caixa = new Pane();
    	Label labelDescricao = new Label();
    	Label labelCategoria = new Label();
    	Label labelEndereco = new Label();
    	
    	TextArea areaDescricao = new TextArea();
    	TextArea areaEndereco = new TextArea();
    	
    	
    	caixa.setLayoutX(53);
    	caixa.setLayoutY(21);
    	caixa.setPrefWidth(263);
    	caixa.setPrefHeight(140);
    	
    	
    	labelDescricao.setText("Descrição");
    	labelDescricao.setLayoutX(23);
    	labelDescricao.setLayoutY(34);
    	
    	labelCategoria.setText("Categoria");
    	labelCategoria.setLayoutX(123);
    	labelCategoria.setLayoutY(14);
    	
    	labelEndereco.setText("Endereço");
    	labelEndereco.setLayoutX(176);
    	labelEndereco.setLayoutY(59);
    	
    	areaDescricao.setLayoutX(23);
    	areaDescricao.setLayoutY(59);
    	
    	areaDescricao.setPrefWidth(107);
    	areaDescricao.setPrefHeight(65);
    	
    	areaEndereco.setLayoutX(157);
    	areaEndereco.setLayoutY(83);
    	areaEndereco.setPrefWidth(87);
    	areaEndereco.setPrefHeight(44);
    	
    	
    	caixa.getChildren().add(labelDescricao);
    	caixa.getChildren().add(labelCategoria);
    	caixa.getChildren().add(labelEndereco);
    	caixa.getStyleClass().add("borda-preta");
    	
    	caixa.getStyleClass().add("borda-preta");
    	
    	caixa.getChildren().add(areaEndereco);
    	caixa.getChildren().add(areaDescricao);
    	caixa.getStylesheets().add(getClass().getResource("styleChamados.css").toExternalForm());
    	
    	scrollBox.getChildren().add(caixa);
    	
    	
    	
    	
    	
    	
        
    }

}