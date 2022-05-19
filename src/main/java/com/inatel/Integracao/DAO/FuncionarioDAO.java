package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Funcionario;

import java.sql.SQLException;

public class FuncionarioDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirFuncionario(Funcionario funcionario) {
        connectToDB();
        String sql = "INSERT INTO funcionario (nome,funcao,horarioInicio,horarioFim,especialidade,cra) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getFuncao());
            pst.setString(3, funcionario.getHorarioInicio());
            pst.setString(3, funcionario.getHorarioFim());
            pst.setString(5, funcionario.getEspecialidade());
            pst.setString(6, funcionario.getCra());
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
}
