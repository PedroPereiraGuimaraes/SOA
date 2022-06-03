package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Atendimento;

import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public boolean deletarAtendimento(int id) {
        connectToDB();
        String sql = "DELETE FROM atendimento WHERE idAtendimento = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
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
    
    
    public ArrayList<Atendimento> pesquisarAtendimento(String nome) {
        ArrayList<Atendimento> listaAtendimentos = new ArrayList<>();
        connectToDB();
        String sql = "SELECT p.nome,a.data,a.hora,a.idAtendimento, a.procedimento, f.nome FROM atendimento AS a INNER JOIN paciente AS p INNER JOIN  funcionarios AS f ON a.Funcionarios_idFuncionarios = f.idFuncionarios AND p.nome = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                Atendimento atendimentos = new Atendimento();
                atendimentos.setData(rs.getString("a.data"));
                atendimentos.setHora(rs.getString("a.hora"));
                atendimentos.setProcedimento(rs.getString("a.procedimento"));
                atendimentos.setId(rs.getInt("idAtendimento"));
                listaAtendimentos.add(atendimentos);
            }
            sucesso = true;
        } catch(SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
            } catch(SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        
        return listaAtendimentos;
    }
}
