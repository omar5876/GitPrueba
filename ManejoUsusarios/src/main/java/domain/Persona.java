
package domain;


public class Persona {
    private int idUsuario;
    private String user;
    private String password;

    public Persona() {
    }

    public Persona(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Persona(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public Persona(int idUsuario, String user, String password) {
        this.idUsuario = idUsuario;
        this.user = user;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Persona{" + "idUsuario=" + idUsuario + ", user=" + user + ", password=" + password + '}';
    }
    
    
}
