package com.inatel.Integracao.Model;

public class Atendimento {

    private int id;
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

    public Atendimento() {
        
    }

    public int getIdPaciente() {
        return idPaciente;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public String getData() {
        return data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }
    
    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getProcedimento() {
        return procedimento;
    }
    
    public void setProcedimento(String procedimento) {
        this.procedimento = procedimento;
    }
}
