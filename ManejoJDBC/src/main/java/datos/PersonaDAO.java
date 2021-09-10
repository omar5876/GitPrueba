package datos;

import domain.Persona;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM test.persona";
    private static final String SQL_INSERT = "INSERT INTO test.persona(nombre, apellido, email, telefono) VALUES (?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM test.persona WHERE id_persona = ?";

    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona> seleccionar() {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = cn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona(idPersona, nombre, apellido, email, telefono);

                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(cn);
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return personas;

    }

    public int insertar(Persona persona) {
        Connection cn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = cn.prepareCall(SQL_INSERT);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(cn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }

    public int actualizar(Persona persona) {
        Connection cn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = cn.prepareStatement(SQL_UPDATE);
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getApellido());
            ps.setString(3, persona.getEmail());
            ps.setString(4, persona.getTelefono());
            ps.setInt(5, persona.getIdPersona());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {

            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(cn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }

    public int eliminar(Persona persona) {
        Connection cn = null;
        PreparedStatement ps = null;
        int registros = 0;
        try {
            cn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            ps = cn.prepareStatement(SQL_DELETE);
            ps.setInt(1, persona.getIdPersona());
            registros = ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(cn);
                }
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return registros;

    }
}
