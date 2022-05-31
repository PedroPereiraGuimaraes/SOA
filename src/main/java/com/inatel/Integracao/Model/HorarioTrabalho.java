package com.inatel.Integracao.Model;


public class HorarioTrabalho {

    private String horarioInicio;
    private String horarioFim;
    private int idFuncionarios;

    public HorarioTrabalho(String horarioInicio, String horarioFim, int idFuncionarios) {
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.idFuncionarios = idFuncionarios;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public int getIdFuncionarios() {
        return idFuncionarios;
    }
}
