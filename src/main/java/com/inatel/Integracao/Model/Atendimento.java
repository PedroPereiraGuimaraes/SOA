package com.inatel.Integracao.Model;

public class Atendimento {

    private String nomePaciente;
    private String idPaciente;
    private String idDentista;
    private String data;
    private int hora;
    private String procedimento;

    public Atendimento(String nomePaciente, String idPaciente, String idDentista, String data, int hora, String procedimento) {
        this.nomePaciente = nomePaciente;
        this.idPaciente = idPaciente;
        this.idDentista = idDentista;
        this.data = data;
        this.hora = hora;
        this.procedimento = procedimento;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getIdDentista() {
        return idDentista;
    }

    public String getData() {
        return data;
    }

    public int getHora() {
        return hora;
    }

    public String getProcedimento() {
        return procedimento;
    }
}
