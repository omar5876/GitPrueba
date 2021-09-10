package domain;

public class Autobus extends Vehiculo {
    //              ^ (Autobus hereda de Vehiculo)
    //Inserte acÃ¡ los atributos

  

    //Inserte acÃ¡ el mÃ©todo constructor
    public Autobus(String nombreConductor, int nMaximoPasajeros) {
        super(nombreConductor, nMaximoPasajeros);
    }

    //Inserte acÃ¡ los mÃ©todos (NO LOS GETTER Y SETTERS)
    public void recogerPasajero(int estrato) {
        if (!this.enMarcha && this.puertaAbierta && this.nPasajeros < this.nMaximoPasajeros) {
            this.cantidadDinero += Autobus.calcularPasaje(estrato);
            this.nPasajeros++;
        }

    }

    @Override
    public void gestionarMarcha() {
        this.enMarcha = (! this.enMarcha && !this.puertaAbierta) ? true : false;
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
    public String getNombreConductor() {
        return nombreConductor;
    }

    @Override
    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    @Override
    public int getnPasajeros() {
        return nPasajeros;
    }

    @Override
    public void setnPasajeros(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    @Override
    public int getnMaximoPasajeros() {
        return nMaximoPasajeros;
    }

    @Override
    public void setnMaximoPasajeros(int nMaximoPasajeros) {
        this.nMaximoPasajeros = nMaximoPasajeros;
    }

    @Override
    public double getCantidadDinero() {
        return cantidadDinero;
    }

    @Override
    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    @Override
    public double getLocalizacionX() {
        return localizacionX;
    }

    @Override
    public void setLocalizacionX(double localizacionX) {
        this.localizacionX = localizacionX;
    }

    @Override
    public double getLocalizacionY() {
        return localizacionY;
    }

    @Override
    public void setLocalizacionY(double localizacionY) {
        this.localizacionY = localizacionY;
    }

    @Override
    public boolean isAireAcondicionadoActivado() {
        return aireAcondicionadoActivado;
    }

    public void setAireAcondicionadoActivado(boolean aireAcondicionadoActivado) {
        this.aireAcondicionadoActivado = aireAcondicionadoActivado;
    }

    public boolean isMotorEncendido() {
        return motorEncendido;
    }

    public void setMotorEncendido(boolean motorEncendido) {
        this.motorEncendido = motorEncendido;
    }

    public boolean isWifiEncendido() {
        return wifiEncendido;
    }

    public void setWifiEncendido(boolean wifiEncendido) {
        this.wifiEncendido = wifiEncendido;
    }

    public boolean isEnMarcha() {
        return enMarcha;
    }

    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }

    public boolean isPuertaAbierta() {
        return puertaAbierta;
    }

    public void setPuertaAbierta(boolean puertaAbierta) {
        this.puertaAbierta = puertaAbierta;
    }

    @Override
    public String toString() {
        return "Autobus{" + super.toString() + '}';
    }

    
}
