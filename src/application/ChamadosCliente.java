package application;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

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
    	
    	
    	try {
    		
    		String sql = "select categoria, descricao, endereco, status from chamados where id='"+SessaoUsuario.getInstance().getId()+"'";
    		
    		Sql bd = new Sql();
    		bd.conectar();
    		
    		ResultSet res = bd.fazerQuery(sql);
    		
    		String categoria = res.getString("categoria");
    		String descricao = res.getString("descricao");
    		String endereco = res.getString("endereco");
    		String status = res.getString("status");
    		
    		int moveY = 21;
    		
    		while(res.next()) {
    			
	    		
			    	Pane caixa = new Pane();
			    	Label labelDescricao = new Label();
			    	Label labelCategoria = new Label();
			    	Label labelEndereco = new Label();
			    	
			    	TextArea areaDescricao = new TextArea();
			    	TextArea areaEndereco = new TextArea();
			    	
			    	//DialogPane caixaConteudo = new DialogPane();
			        
			    	caixa.setLayoutX(60);
			    	caixa.setLayoutY(moveY);
			    	caixa.setPrefWidth(263);
			    	caixa.setPrefHeight(140);
			    	
			    	
			    	labelDescricao.setText(descricao);
			    	labelDescricao.setLayoutX(193);
			    	labelDescricao.setLayoutY(23);
			    	
			    	labelCategoria.setText(categoria);
			    	labelCategoria.setLayoutX(14);
			    	labelCategoria.setLayoutY(14);
			    	labelCategoria.getStyleClass().add("titulo");
			    	
			    	labelEndereco.setText(endereco);
			    	labelEndereco.setLayoutX(176);
			    	labelEndereco.setLayoutY(59);
			    	
			    	areaDescricao.setLayoutX(23);
			    	areaDescricao.setLayoutY(59);
			    	areaDescricao.wrapTextProperty().set(true);
			    	areaDescricao.editableProperty().set(false);
			    	
			    	areaDescricao.setPrefWidth(107);
			    	areaDescricao.setPrefHeight(65);
			    	
			    	
			    	areaEndereco.setLayoutX(157);
			    	areaEndereco.setLayoutY(83);
			    	areaEndereco.setPrefWidth(87);
			    	areaEndereco.setPrefHeight(44);
			    	
			    	areaEndereco.wrapTextProperty().set(true);
			    	areaEndereco.editableProperty().set(false);
			    	
			    	
			    	areaDescricao.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			            event.consume();
			        });
			    	
			    	areaEndereco.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			            event.consume();
			        });
			    	
			    	caixa.getChildren().add(labelDescricao);
			    	caixa.getChildren().add(labelCategoria);
			    	caixa.getChildren().add(labelEndereco);
			    	caixa.getStyleClass().add("borda-preta");
			    	
			    	//caixa.getStyleClass().add("borda-preta");
			    	
			    	caixa.getChildren().add(areaEndereco);
			    	caixa.getChildren().add(areaDescricao);
			    	caixa.getStylesheets().add(getClass().getResource("styleChamados.css").toExternalForm());
			    	DropShadow dropShadow = new DropShadow();
			        dropShadow.setColor(Color.BLACK);
			        dropShadow.setRadius(10);
			        dropShadow.setOffsetX(3);
			        dropShadow.setOffsetY(1);
			        Color paint = new Color(0.0, 0.0, 0.0, 0.4286);
			        dropShadow.setColor(paint);
			        //caixa.setEffect(dropShadow);
			        
			        scrollBox.setEffect(dropShadow);
			    	
			    	scrollBox.getChildren().add(caixa);
    		}
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	//Color paint = new Color(0.0, 0.0, 0.0, 0.5805);
    	
    	
        
    }

}