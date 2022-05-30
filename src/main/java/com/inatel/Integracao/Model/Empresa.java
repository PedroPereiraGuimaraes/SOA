package com.inatel.Integracao.Model;


public class Empresa {
    
    private String nome;
    private String senha;

    public Empresa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public Empresa(){
        
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
}
