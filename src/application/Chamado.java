package application;

import java.io.IOException;
import java.sql.ResultSet;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Chamado {
	
	private String descricao;
	private String categoria;
	private String endereco;
	private String id_cliente;
	private String id_fornecedor;
	
	public Chamado(String descricao,  String categoria,  String endereco,  String id_cliente) {
		this.categoria = categoria;
		this.descricao = descricao;
		this.endereco = endereco;
		this.id_cliente = id_cliente;
	}
	
	
	public void abrirChamado(){
		Sql sql = new Sql();
		
		sql.conectar();
		
		String query = "INSERT INTO `chamados`(`categoria`, `descricao`, `endereco`, `usuario_id`, `status`) "
				+ "VALUES ('"+this.categoria+"','"+this.descricao+"','"+this.endereco+"','"+this.id_cliente+"','Aberto')";
		
		sql.insertQuery(query);
	}
	
	
	
	
	public void setDescricao(String desc){
		this.descricao = desc;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
	
	public void setCategoria(String cat){
		this.categoria = cat;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
	public void setEndereco(String enderec){
		this.endereco = enderec;
	}
	
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setIdCliente(String id){
		this.id_cliente = id;
	}
	
	public String getIdCliente() {
		return this.id_cliente;
	}
	
	public void setIdFornecedor(String id){
		this.id_fornecedor = id;
	}
	
	public String getIdForcedor() {
		return this.id_fornecedor;
	}
	
	public void chamadosCliente(AnchorPane scrollBox) {
		String sql = "select id, categoria, descricao, endereco, status from chamados where usuario_id='"+SessaoUsuario.getInstance().getId()+"'";
		
		Sql bd = new Sql();
		try {
			bd.conectar();
			ResultSet res = bd.fazerQuery(sql);
			listarChamados(scrollBox, res, 0);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void chamadosDisponiveis(AnchorPane scrollBox) {
		String sql = "select id, categoria, descricao, endereco, status from chamados where status='Aberto' and categoria='"+SessaoFornecedor.getInstance().getCategorias().get(0)+"' or status='Aberto' and categoria='"+SessaoFornecedor.getInstance().getCategorias().get(1)+"' or status='Aberto' and categoria='"+SessaoFornecedor.getInstance().getCategorias().get(2)+"'";
		
		Sql bd = new Sql();
		
		try {
			bd.conectar();
			ResultSet res = bd.fazerQuery(sql);
			listarChamados(scrollBox, res, 1);
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void chamadosAceitos(AnchorPane scrollBox) {
		String sql = "select id, categoria, descricao, endereco, status from chamados where status='Em andamento' and fornecedor_id='"+SessaoFornecedor.getInstance().getId()+"'";
		
		Sql bd = new Sql();
		
		try {
			bd.conectar();
			ResultSet res = bd.fazerQuery(sql);
			listarChamados(scrollBox, res, 2);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/*
	 * tipos
	 * 0 - chamados do cliente
	 * 1 - chamados disponiveis
	 * 2 - chamados aceitos
	 * 
	 */
	
	
	public void listarChamados(AnchorPane scrollBox, ResultSet res, int tipo) {
try {
    		
	
    		
    		int moveY = 162;
    		int paneHeight = 400;
    		int space = 0;
    		int tamanho = 0;
    		
    		while(res.next()) {
	    			String categoria = res.getString("categoria");
	        		String descricao = res.getString("descricao");
	        		String endereco = res.getString("endereco");
	        		String status = res.getString("status");
	    		
			    	Pane caixa = new Pane();
			    	//Label labelDescricao = new Label();
			    	Label labelCategoria = new Label();
			    	Label labelEndereco = new Label();
			    	
			    	TextArea areaDescricao = new TextArea();
			    	TextArea areaEndereco = new TextArea();
			    	
			    	//DialogPane caixaConteudo = new DialogPane();
			        
			    	caixa.setLayoutX(293);
			    	caixa.setLayoutY(moveY);
			    	caixa.setPrefWidth(700);
			    	caixa.setPrefHeight(390);
			    	
			    	
			    		
			    	
					if(tipo==1) {
								    		
						Button labelDescricao = new Button("Aceitar chamado");
						labelDescricao.setLayoutX(495);
				    	labelDescricao.setLayoutY(51);
				    	labelDescricao.getStyleClass().add("aceitar-chamado");
				    	
				    	Label labelId = new Label();
				    	String strId = res.getString("id");
				    	labelId.setText(strId);
				    	labelId.setVisible(false);
				    	
				    	
				    	//labelDescricao.setText("Aceitar Chamado");
				    	
				    	caixa.getChildren().add(labelDescricao);
				    	labelDescricao.setOnAction(new EventHandler<ActionEvent>() {
				    		@Override
				            public void handle(ActionEvent event) {
				    			try {
				    				aceitarChamado(labelDescricao, strId);
				    			}catch (Exception e) {
									System.out.println(e);
								}
				                
				            }
				            
				        });
				    	
					
					
					
					
			    	}
			    	
			    	if(tipo == 0) {
			    		
							
							Label labelDescricao = new Label();
							labelDescricao.setText(status);
					    	labelDescricao.setLayoutX(506);
					    	labelDescricao.setLayoutY(51);
					    	labelDescricao.getStyleClass().add("labelTexto");
					    	caixa.getChildren().add(labelDescricao);
						
			    	}
			    	
					if(status.equals("Em andamento") && tipo==0) {
						System.out.println("kkk");
						Button finalizar = new Button("Finalizar Chamado");
						finalizar.setLayoutX(495);
				    	finalizar.setLayoutY(118);
				    	finalizar.getStyleClass().add("aceitar-chamado");
				    	
				    	Label labelId = new Label();
				    	String strId = res.getString("id");
				    	labelId.setText(strId);
				    	labelId.setVisible(false);
				    	
				    	
				    	//labelDescricao.setText("Aceitar Chamado");
				    	
				    	caixa.getChildren().add(finalizar);
				    	finalizar.setOnAction(new EventHandler<ActionEvent>() {
				    		@Override
				            public void handle(ActionEvent event) {
				    			try {
				    				finalizarChamado(finalizar, strId);
				    			}catch (Exception e) {
									System.out.println(e);
								}
				                
				            }
				            
				        });
					}
			    	
			    	
			    	
			    	labelCategoria.setText(categoria);
			    	labelCategoria.setLayoutX(68);
			    	labelCategoria.setLayoutY(46);
			    	labelCategoria.getStyleClass().add("titulo");
			    	
			    	labelEndereco.setText("Endereço");
			    	labelEndereco.setLayoutX(499);
			    	labelEndereco.setLayoutY(260);
			    	labelEndereco.getStyleClass().add("labelTexto");
			    	
			    	
			    	areaDescricao.setLayoutX(63);
			    	areaDescricao.setLayoutY(145);
			    	areaDescricao.wrapTextProperty().set(true);
			    	areaDescricao.editableProperty().set(false);
			    	
			    	areaDescricao.setPrefWidth(299);
			    	areaDescricao.setPrefHeight(179);
			    	areaDescricao.setText(descricao);
			    	areaDescricao.getStyleClass().add("textArea");
			    	
			    	areaEndereco.setLayoutX(444);
			    	areaEndereco.setLayoutY(296);
			    	areaEndereco.setPrefWidth(185);
			    	areaEndereco.setPrefHeight(25);
			    	areaEndereco.setText(endereco);
			    	areaEndereco.getStyleClass().add("endereco");
			    	
			    	areaEndereco.wrapTextProperty().set(true);
			    	areaEndereco.editableProperty().set(false);
			    	
			    	
			    	areaDescricao.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			            event.consume();
			        });
			    	
			    	areaEndereco.addEventFilter(MouseEvent.MOUSE_PRESSED, event -> {
			            event.consume();
			        });
			    	
			    	
			    	caixa.getChildren().add(labelCategoria);
			    	caixa.getChildren().add(labelEndereco);
			    	
			    	if(status.equals("Aberto")) {
			    		caixa.getStyleClass().add("card-aberto");
			    		
			    	}else if(status.equals("Em andamento")) {
			    		
			    		caixa.getStyleClass().add("card-andamento");
			    		
			    	}else if(status.equals("Finalizado")){
			    		caixa.getStyleClass().add("card-finalizado");
			    	}
			    	
			    	
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
			        scrollBox.setEffect(dropShadow);
			        
			        tamanho += paneHeight + space;
			        scrollBox.setEffect(dropShadow);
			    	
			    	scrollBox.getChildren().add(caixa);
			    	
			    	moveY += 418;
    		}
    		
    		scrollBox.setPrefHeight(tamanho);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	//Color paint = new Color(0.0, 0.0, 0.0, 0.5805);
    	
    	
        
    }
	
	
	public void aceitarChamado(Node elemento, String id) throws IOException {
		Sql bd = new Sql();
		bd.conectar();
		Janela janela = new Janela();
		bd.insertQuery("update chamados set status='Em andamento', fornecedor_id='"+SessaoFornecedor.getInstance().getId()+"' where id='"+id+"'");
		janela.novaJanela(elemento, "../gui/MenuPrestadorServiço.fxml", "Menu");
	}
	
	public void finalizarChamado(Node elemento, String id) throws IOException {
		Sql bd = new Sql();
		bd.conectar();
		Janela janela = new Janela();
		bd.insertQuery("update chamados set status='Finalizado' where id='"+id+"'");
		janela.novaJanela(elemento, "../gui/ChamadosCliente.fxml", "Menu");
	}
	
	
	
	
}
	
	

