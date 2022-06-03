package com.inatel.Integracao.Model;
public class Funcionario {

    private int id;
    private String nome;
    private String funcao;
    private String especialidade;
    private String cra;
    private String empresa;

    public Funcionario(String nome, String funcao, String especialidade, String cra, String empresa) {
        this.nome = nome;
        this.funcao = funcao;
        this.especialidade = especialidade;
        this.cra = cra;
        this.empresa = empresa;
    }
    
    public Funcionario(){
        
    }

    public String getNome() {
        return nome;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public int getId() {
        return id;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCra() {
        return cra;
    }
}
