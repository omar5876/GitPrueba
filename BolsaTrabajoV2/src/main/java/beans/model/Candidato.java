
package beans.model;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped

public class Candidato {
    private String nombre;
    private String apellido;
    private int salarioDeseado;
    private Date fechaNacimiento;
    
    Logger log = LogManager.getRootLogger();
    
    public Candidato(){
        log.info("Creando el objeto candidato");
        this.setNombre("introduce tu Nombre");
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre " + this.nombre);
    }
    
    public String getApellido(){
        return this.apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
        log.info("Modificando la propiedad de Apellido " + this.apellido);
    }
    
    public int getSalarioDeseado(){
        return this.salarioDeseado;
    }
    
    public void setSalarioDeseado(int salarioDeseado){
        this.salarioDeseado = salarioDeseado;
        log.info("Modificando la propiedad de salario deseado " + this.salarioDeseado);
    }
    
    public Date getFechaNacimiento(){
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento){
        this.fechaNacimiento = fechaNacimiento;
    }
}
