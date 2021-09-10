
import datos.Conexion;
import datos.PersonaDAO;
import domain.Persona;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TestManejoPersonas {

    public static void main(String[] args) {
        Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
                PersonaDAO personaDAO = new PersonaDAO(conexion);
                Persona persona1 = new Persona(2, "Off The Wall", "Michael", "Jackon", "1979");
                personaDAO.actualizar(persona1);
                
                Persona persona2 = new Persona("History", "Michael", "Jackson", "1995");
                personaDAO.insertar(persona2);
                
                conexion.commit();
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try {
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }

    }
}
