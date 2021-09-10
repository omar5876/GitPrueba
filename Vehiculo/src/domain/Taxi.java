package domain;

public class Taxi extends Vehiculo {
    //           ^ (Taxi hereda de Vehiculo)
    //Inserte acÃ¡ los atributos

    private double distanciaRecorrida;
    private boolean segurosActivados;

    //Inserte acÃ¡ el mÃ©todo constructor
    public Taxi(String nombreConductor) {
        super(nombreConductor);
        this.distanciaRecorrida = 0;
        this.segurosActivados = false;
        this.nMaximoPasajeros = 1;
    }

    //Inserte acÃ¡ los mÃ©todos (NO LOS GETTER Y SETTERS)
    public void reiniciarTaximetro() {
        this.distanciaRecorrida = 0;
    }

    public void presionarBotonPanico() {
        this.enMarcha = false;
        this.segurosActivados = false;
        this.nPasajeros = 0;
        this.reiniciarTaximetro();

    }

    public void dejarPasajero() {
        if (!this.enMarcha && this.puertaAbierta) {
            this.cantidadDinero += this.calcularPasaje();
            this.nPasajeros = 0;
            this.distanciaRecorrida = 0;
        }

    }

    public void recogerPasajero() {
        if (this.nPasajeros < this.nMaximoPasajeros && !this.enMarcha) {
            this.nPasajeros = 1;
        }

    }

    public void gestionarSeguros() {
//        if (this.enMarcha) {
//            this.segurosActivados = true;
//        }else if(! this.enMarcha){
//            this.segurosActivados = false;
//        }
        this.segurosActivados = !this.segurosActivados;
    }

    public double calcularPasaje() {
        double pasaje = 0;
        if (this.enMarcha && this.nPasajeros > 0) {
            pasaje = 3000 + 2300 * this.distanciaRecorrida;
        } else {
            pasaje = 0;
        }
        return pasaje;
    }

    @Override
    public void moverDerecha(double d) {
        if (this.enMarcha) {
            this.localizacionX += d;
            if (this.nPasajeros > 0) {
            this.distanciaRecorrida += d;
        }
        }
        
    }

    @Override
    public void moverIzquierda(double d) {
        if (this.enMarcha) {
            this.localizacionX -= d;
            if (this.nPasajeros > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void moverAbajo(double d) {
        if (this.enMarcha) {
            this.localizacionY += d;
            if (this.nPasajeros > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void moverArriba(double d) {
        if (this.enMarcha) {
            this.localizacionX -= d;
            if (this.nPasajeros > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void gestionarMarcha() {
        this.enMarcha = (this.segurosActivados && !this.enMarcha) ? true : false;
    }

    //Inserte acÃ¡ los SETTERS Y GETTERS
    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public boolean isSegurosActivados() {
        return segurosActivados;
    }

    public void setSegurosActivados(boolean segurosActivados) {
        this.segurosActivados = segurosActivados;
    }

    @Override
    public String toString() {
        return "Taxi{" + "distanciaRecorrida=" + distanciaRecorrida + ", segurosActivados=" + segurosActivados + super.toString() + '}';
    }

}
