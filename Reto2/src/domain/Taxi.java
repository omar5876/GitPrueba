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
        //this.nMaximoPasajeros = 1;
        this.setnMaximoPasajeros(1);
    }

    //Inserte acÃ¡ los mÃ©todos (NO LOS GETTER Y SETTERS)
    public void reiniciarTaximetro() {
        this.distanciaRecorrida = 0;
    }

    public void presionarBotonPanico() {
        //this.enMarcha = false;
        this.setEnMarcha(false);
        this.segurosActivados = false;
        //this.nPasajeros = 0;
        this.setnPasajeros(0);
        this.reiniciarTaximetro();

    }

    public void dejarPasajero() {
        if (!this.isEnMarcha() && this.isPuertaAbierta()) {
            this.setCantidadDinero(this.getCantidadDinero() + this.calcularPasaje());
            //this.nPasajeros = 0;
            this.setnPasajeros(0);
            this.distanciaRecorrida = 0;
        }

    }

    public void recogerPasajero() {
        if (this.getnPasajeros() < this.getnMaximoPasajeros() && !this.isEnMarcha()) {
            //this.nPasajeros = 1;
            this.setnPasajeros(1);
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
        if (this.isEnMarcha() && this.getnPasajeros() > 0) {
            pasaje = 3000 + 2300 * this.distanciaRecorrida;
        } else {
            pasaje = 0;
        }
        return pasaje;
    }

    @Override
    public void moverDerecha(double d) {
        if (this.isEnMarcha()) {
            this.setLocalizacionX(this.getLocalizacionX() + d);
            if (this.getnPasajeros() > 0) {
            this.distanciaRecorrida += d;
        }
        }
        
    }

    @Override
    public void moverIzquierda(double d) {
        if (this.isEnMarcha()) {
            this.setLocalizacionX(this.getLocalizacionX() - d);
            if (this.getnPasajeros() > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void moverAbajo(double d) {
        if (this.isEnMarcha()) {
            this.setLocalizacionY(this.getLocalizacionY() - d);
            if (this.getnPasajeros() > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void moverArriba(double d) {
        if (this.isEnMarcha()) {
            this.setLocalizacionY(this.getLocalizacionY() + d);
            if (this.getnPasajeros() > 0) {
                this.distanciaRecorrida += d;
            }
        }

    }

    @Override
    public void gestionarMarcha() {
        //this.enMarcha = (this.segurosActivados && !this.enMarcha) ? true : false;
        if (this.segurosActivados && !this.isEnMarcha()) {
            this.setEnMarcha(true);
        }else{
            this.setEnMarcha(false);
        }
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
