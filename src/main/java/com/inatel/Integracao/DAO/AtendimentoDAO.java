package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Atendimento;

import java.sql.SQLException;

public class AtendimentoDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirAtendimento(Atendimento atendimento) {
        connectToDB();
        String sql = "INSERT INTO atendimento (data,hora,procedimento,Funcionarios_idFuncionarios,Paciente_idPaciente) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, atendimento.getData());
            pst.setString(2, atendimento.getHora());
            pst.setString(3, atendimento.getProcedimento());
            pst.setInt(4, atendimento.getIdFuncionario());
            pst.setInt(5, atendimento.getIdPaciente());
            pst.execute();
            sucesso = true;
        } catch(SQLException exc) {
            System.out.println("Erro: " + exc.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch(SQLException exc) {
                System.out.println("Erro: " + exc.getMessage());
            }
        }
        return sucesso;
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
