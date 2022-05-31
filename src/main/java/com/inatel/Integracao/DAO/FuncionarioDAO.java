package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Funcionario;

import java.sql.SQLException;

public class FuncionarioDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirFuncionario(Funcionario funcionario) {
        connectToDB();
        String sql = "INSERT INTO funcionarios (nome,funcao,especialidade,cra,Empresa_idEmpresa) values(?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getFuncao());
            pst.setString(3, funcionario.getEspecialidade());
            pst.setString(4, funcionario.getCra());
            pst.setString(5, funcionario.getEmpresa());
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
    
    public int buscarIdFuncionario(String nome) {
        int id = 0;
        connectToDB();
        String sql = "SELECT idFuncionarios FROM funcionarios WHERE nome = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getInt("idFuncionarios");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            id = 0;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return id;
    }
    
    public boolean buscarFuncionario(String nome) {
        connectToDB();
        String sql = "SELECT * FROM funcionarios WHERE nome = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                String aux = rs.getString("nome");
                sucesso = !aux.isEmpty();
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            sucesso = false;
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return sucesso;
    }
}
