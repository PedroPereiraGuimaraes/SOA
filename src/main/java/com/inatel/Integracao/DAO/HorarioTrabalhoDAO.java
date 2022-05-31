package com.inatel.Integracao.DAO;

import com.inatel.Integracao.Model.HorarioTrabalho;
import java.sql.SQLException;

public class HorarioTrabalhoDAO extends ConnectionDAO{
    
    
    public void inserirHorarioTrabalho(HorarioTrabalho horarioTrabalho) {
        connectToDB();
        String sql = "INSERT INTO horariotrabalho (horarioComeco,horarioTermino,Funcionarios_idFuncionarios) values(?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, horarioTrabalho.getHorarioInicio());
            pst.setString(2, horarioTrabalho.getHorarioFim());
            pst.setInt(3, horarioTrabalho.getIdFuncionarios());
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
}
