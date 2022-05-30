package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Empresa;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmpresaDAO extends ConnectionDAO {

    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirEmpresa(Empresa empresa) {
        connectToDB();
        String sql = "INSERT INTO empresa (nome,senha) values(?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, empresa.getNome());
            pst.setString(2, empresa.getSenha());
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
     
    public boolean buscarEmpresa(String nome, String senha) {
        connectToDB();
        String sql = "SELECT * FROM empresa WHERE nome = ? and senha = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            pst.setString(2, senha);
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
    
    public String buscarIdEmpresa(String nome) {
        String id = "";
        connectToDB();
        String sql = "SELECT idEmpresa FROM empresa WHERE nome = ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                id = rs.getString("idEmpresa");
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
            id = "";
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
}
