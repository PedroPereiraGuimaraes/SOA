package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.Paciente;

import java.sql.SQLException;

public class PacienteDAO extends ConnectionDAO {

    //DAO - Data Access Object
    boolean sucesso = false; //Para saber se funcionou

    public boolean inserirPaciente(Paciente paciente) {
        connectToDB();
        String sql = "INSERT INTO paciente (nome,pais,estado,cidade,telefone,email) values(?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, paciente.getNome());
            pst.setString(2, paciente.getPais());
            pst.setString(3, paciente.getEstado());
            pst.setString(4, paciente.getCidade());
            pst.setString(5, paciente.getTelefone());
            pst.setString(6, paciente.getEmail());
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
    
    public int buscarIdPaciente(String nome) {
        connectToDB();
        Paciente p = null;
        String sql = "SELECT nome,idPaciente FROM paciente WHERE nome like ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, nome);
            rs = pst.executeQuery();
            while (rs.next()) {
                
                String id =rs.getString("nome");
            
                if(id.isEmpty())
                {
                    sucesso= false;
                } else {
                    p = new Paciente();
                    p.setId(rs.getInt("idPaciente"));
                    System.out.println(p.getId());
                } 
            }
        } catch (SQLException e) {
            System.out.println("Erro: " + e.getMessage());
        } finally {
            try {
                con.close();
                pst.close();
            } catch (SQLException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
        return p.getId();
    }
    
    public boolean buscarPaciente(String nome) {
        connectToDB();
        String sql = "SELECT * FROM paciente WHERE nome like ?";
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
