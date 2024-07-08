package application;

public class SessaoUsuario {
    private static SessaoUsuario instance;
    private String id;
    private String nome;

    SessaoUsuario() {
        
    }

    public static SessaoUsuario getInstance() {
        if (instance == null) {
            instance = new SessaoUsuario();
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
    
    public void limparSessao() {
    	this.nome = null;
    	this.id = null;
    	
    }
}
