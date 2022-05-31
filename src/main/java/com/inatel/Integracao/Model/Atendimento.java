package com.inatel.Integracao.Model;

public class Atendimento {

    private int idPaciente;
    private int idFuncionario;
    private String data;
    private String hora;
    private String procedimento;

    public Atendimento(String data, String hora, String procedimento,int idPaciente, int idFuncionario) {
        this.idPaciente = idPaciente;
        this.idFuncionario = idFuncionario;
        this.data = data;
        this.hora = hora;
        this.procedimento = procedimento;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getProcedimento() {
        return procedimento;
    }
}
