package com.inatel.Integracao.Model;

public class Paciente {

    private String nome;
    private String cpf;
    private String estado;
    private String cidade;
    private String telefone;
    private String email;

    public Paciente(String nome, String cpf, String estado, String cidade, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.estado = estado;
        this.cidade = cidade;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
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
