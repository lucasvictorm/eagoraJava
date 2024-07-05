package application;

import java.util.List;

public class SessaoFornecedor {
	private  List<String> categorias;
	private String nome;
	private String id;
	private static SessaoFornecedor instance;
  
	
    SessaoFornecedor() {
       
    }

    public static SessaoFornecedor getInstance() {
        if (instance == null) {
            instance = new SessaoFornecedor();
        }
        return instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<String> getCategorias(){
    	return categorias;
    }
    
    
    public void setCategorias(String cat){
    	this.categorias.add(cat);
    }
}
