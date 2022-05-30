package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Atendimento;

import java.sql.SQLException;

public class AtendimentoDAO extends ConnectionDAO {

    //DAO - Data Access Object

    public void inserirAtendimento(Atendimento atendimento) {
        connectToDB();
        String sql = "INSERT INTO funcionario (nomePaciente,idPaciente,idFuncionario,dataAtendimento,horaAtendimento,procedimento) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, atendimento.getNomePaciente());
            pst.setString(2, atendimento.getIdPaciente());
            pst.setString(3, atendimento.getIdFuncionario());
            pst.setString(3, atendimento.getData());
            pst.setInt(3, atendimento.getHora());
            pst.setString(6, atendimento.getProcedimento());
            pst.execute();
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
    }
    
    public String pesquisarAtendimento(String nome) {
        connectToDB();
        String saida;
        String sql = "SELECT nomePaciente, data, hora, procedimento FROM atendimento WHERE nome  LIKE '%" + nome +"%'";
        try {
            pst = con.prepareStatement(sql);
            pst.execute();
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return "Nada";
    }
}
