
package test;

import datos.*;
import domain.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Test {
    public static void main(String[] args) {
        Connection conexion = null;
        
        try {
            conexion = Conexion.getConection();
            if (conexion.getAutoCommit()) {
                conexion.setAutoCommit(false);
           }
            PersonaDAO personaDAO = new PersonaDAO(conexion);
            
            Persona persona1 = new Persona(2, "Thriller", "1982");
            personaDAO.update(persona1);
            
            Persona persona2 = new Persona("Invincible", "2001");
            personaDAO.insert(persona2);
            
            conexion.commit();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            try {
                System.out.println("Se hizo rollback");
                conexion.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace(System.out);
            }
        }
    }
}
