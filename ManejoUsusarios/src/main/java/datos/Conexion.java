
package datos;

import java.sql.*;


public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/test?useSSL=false&useTimeZone=true&serverTimeZone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    
    public static Connection getConection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void close(ResultSet rs) throws SQLException{
        rs.close();
    
    }
    
    public static void close(PreparedStatement ps) throws SQLException{
        ps.close();
    }
    
    public static void close(Statement s) throws SQLException{
        s.close();
    }
    
    public static void close(Connection c) throws SQLException{
        c.close();
    }
}
