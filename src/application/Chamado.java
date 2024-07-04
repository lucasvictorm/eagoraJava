package application;

import java.sql.ResultSet;

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
				+ "VALUES ('"+this.categoria+"','"+this.descricao+"','"+this.endereco+"','"+this.id_cliente+"','aberto')";
		
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
	
	
	
	
}
