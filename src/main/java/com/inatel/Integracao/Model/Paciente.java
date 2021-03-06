package com.inatel.Integracao.Model;

public class Paciente {
    
    private int id;
    private String nome;
    private String pais;
    private String estado;
    private String cidade;
    private String telefone;
    private String email;

    public Paciente(String nome, String pais, String estado, String cidade, String telefone, String email) {
        this.nome = nome;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
    }
    
    public Paciente(){
        
    }

    public String getNome() {
        return nome;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public String getEstado() {
        return estado;
    }

    public String getCidade() {
        return cidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
}
