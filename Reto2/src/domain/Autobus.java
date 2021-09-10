package domain;

public class Autobus extends Vehiculo {
    //              ^ (Autobus hereda de Vehiculo)
    //Inserte acÃ¡ los atributos

  

    //Inserte acÃ¡ el mÃ©todo constructor
    public Autobus(String nombreConductor, int nMaximoPasajeros) {
        super(nombreConductor, nMaximoPasajeros);
    }

    //Inserte acÃ¡ los mÃ©todos (NO LOS GETTER Y SETTERS)
    
    public void dejarPasajero() {
        if (!this.isEnMarcha() && this.isPuertaAbierta() && this.getnPasajeros() > 0) {
            this.setnPasajeros(this.getnPasajeros() - 1);
        }

    }
      
    public void recogerPasajero(int estrato) {
        if (!this.isEnMarcha() && this.isPuertaAbierta() && this.getnPasajeros() < this.getnMaximoPasajeros()) {
            //this.cantidadDinero += Autobus.calcularPasaje(estrato);
            this.setCantidadDinero(this.getCantidadDinero() + Autobus.calcularPasaje(estrato));
            this.setnPasajeros(this.getnPasajeros() + 1);
        }

    }

    @Override
    public void gestionarMarcha() {
        if (! this.isEnMarcha() && !this.isPuertaAbierta()) {
            this.setEnMarcha(true);
        }else{
            this.setEnMarcha(false);
        }
        //this.enMarcha = (! this.enMarcha && !this.puertaAbierta) ? true : false;
    }



    public static double calcularPasaje(int estrato) {
        double valor = 0;
        if (estrato >= 0 && estrato <= 2) {
            valor = 1500;
        } else if (estrato >= 3 && estrato <= 4) {
            valor = 2600;
        } else if (estrato >= 5 && estrato <= 6) {
            valor = 3000;
        }
        return valor;
        
    }
    //Inserte acÃ¡ los SETTERS Y GETTERS

   

    @Override
    public String toString() {
        return "Autobus{" + super.toString() + '}';
    }

    
}
