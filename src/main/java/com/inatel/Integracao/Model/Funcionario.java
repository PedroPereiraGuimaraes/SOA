package com.inatel.Integracao.Model;
public class Funcionario {

    private String nome;
    private String funcao;
    private String horarioInicio;
    private String horarioFim;
    private String especialidade;
    private String cra;

    public Funcionario(String nome, String funcao, String horarioInicio, String horarioFim, String especialidade, String cra) {
        this.nome = nome;
        this.funcao = funcao;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.especialidade = especialidade;
        this.cra = cra;
    }

    public String getNome() {
        return nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCra() {
        return cra;
    }
}
