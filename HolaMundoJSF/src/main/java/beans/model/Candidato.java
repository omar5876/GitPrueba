
package beans.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Named
@RequestScoped

public class Candidato {
    private String nombre = "Introduce tu Nombre";
    
    Logger log = LogManager.getRootLogger();
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
        log.info("Modificando la propiedad de nombre " + this.nombre);
    }
}
