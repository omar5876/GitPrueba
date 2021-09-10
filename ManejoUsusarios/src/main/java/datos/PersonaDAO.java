package datos;

import domain.*;
import java.sql.*;
import java.util.*;

public class PersonaDAO {

    private Connection conexionTransaccional;
    private static final String SELECT = "SELECT id_usuario, usuario, password FROM sga.usuario";
    private static final String INSERT = "INSERT INTO sga.usuario (usuario, password) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE sga.usuario SET usuario = ?, password = ? WHERE id_usuario = ?";
    private static final String DELETE = "DELETE FROM sga.usuario WHERE id_usuario = ?";

    public PersonaDAO() {
    }

    public PersonaDAO(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona> select() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Persona persona = null;
        List<Persona> personas = new ArrayList<>();

        try {
            c = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection();
            ps = c.prepareStatement(SELECT);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                persona = new Persona(idUsuario, usuario, password);

                personas.add(persona);
            }
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(c);
                }

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }

        }
        return personas;
    }

    public int insert(Persona persona) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            c = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection();

            ps = c.prepareStatement(INSERT);

            ps.setString(1, persona.getUser());
            ps.setString(2, persona.getPassword());

            registros = ps.executeUpdate();
        }finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(c);
                }
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int update(Persona persona) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            c = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection();
            ps = c.prepareStatement(UPDATE);

            ps.setString(1, persona.getUser());
            ps.setString(2, persona.getPassword());
            ps.setInt(3, persona.getIdUsuario());

            registros = ps.executeUpdate();
        } finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(c);
                }
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }

    public int delete(Persona persona) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        int registros = 0;

        try {
            c = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConection();
            ps = c.prepareStatement(DELETE);

            ps.setInt(1, persona.getIdUsuario());

            registros = ps.executeUpdate();
        }finally {
            try {
                Conexion.close(ps);
                if (this.conexionTransaccional == null) {
                    Conexion.close(c);
                }
            } catch (SQLException ex) {

                ex.printStackTrace(System.out);
            }

        }
        return registros;
    }
}
