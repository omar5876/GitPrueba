package domain;

public abstract class Vehiculo {
    //Inserte acÃ¡ los atributos

    protected String nombreConductor;
    protected int nPasajeros;
    protected int nMaximoPasajeros;
    protected double cantidadDinero;
    protected double localizacionX;
    protected double localizacionY;
    protected boolean aireAcondicionadoActivado;
    protected boolean motorEncendido;
    protected boolean wifiEncendido;
    protected boolean enMarcha;
    protected boolean puertaAbierta;

    //Inserte acÃ¡ el mÃ©todo constructor
    
    public Vehiculo(String nombreConductor) {
        this.nombreConductor = nombreConductor;

    }

    public Vehiculo(String nombreConductor, int nMaximoPasajeros) {
        this.nombreConductor = nombreConductor;
        this.nPasajeros = 0;
        this.nMaximoPasajeros = nMaximoPasajeros;
        this.cantidadDinero = 0;
        this.localizacionX = 0;
        this.localizacionY = 0;
        this.aireAcondicionadoActivado = false;
        this.motorEncendido = false;
        this.wifiEncendido = false;
        this.enMarcha = false;
        this.puertaAbierta = false;
    }

    //Inserte acÃ¡ los mÃ©todos (NO LOS GETTER Y SETTERS)
    public void dejarPasajero() {
        if (!this.enMarcha && this.puertaAbierta && this.nPasajeros > 0) {
            this.nPasajeros--;
        }

    }

    public double calcularDistanciaAcopio() {
        return Math.sqrt((Math.pow(localizacionX, 2)) + (Math.pow(localizacionY, 2)));
    }

    public void gestionarAireAcondicionado() {
        if (this.motorEncendido && !this.aireAcondicionadoActivado) {
            this.aireAcondicionadoActivado = true;
        } else {
            this.aireAcondicionadoActivado = false;
        }

    }

    public void gestionarMotor() {
        this.motorEncendido = !this.motorEncendido;

        if (!this.motorEncendido) {
            this.wifiEncendido = false;
            this.aireAcondicionadoActivado = false;
        }
    }

    public void gestionarWifi() {
        this.wifiEncendido = (this.motorEncendido && !this.wifiEncendido) ? true : false;
    }

    public abstract void gestionarMarcha();

    public void moverDerecha(double d) {
        if (this.enMarcha) {
            this.localizacionX += d;
        }
    }

    public void moverIzquierda(double d) {
        if (this.enMarcha) {
            this.localizacionX -= d;
        }
    }

    public void moverArriba(double d) {
        if (this.enMarcha) {
            this.localizacionY += d;
        }
    }

    public void moverAbajo(double d) {
        if (this.enMarcha) {
            this.localizacionY -= d;
        }
    }

    public void gestionarPuerta() {
        this.puertaAbierta = (!this.enMarcha && !this.puertaAbierta) ? true : false;
    }

    //Inserte acÃ¡ los SETTERS Y GETTERS
    public String getNombreConductor() {
        return nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public int getnPasajeros() {
        return nPasajeros;
    }

    public void setnPasajeros(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    public int getnMaximoPasajeros() {
        return nMaximoPasajeros;
    }

    public void setnMaximoPasajeros(int nMaximoPasajeros) {
        this.nMaximoPasajeros = nMaximoPasajeros;
    }

    public double getCantidadDinero() {
        return cantidadDinero;
    }

    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public double getLocalizacionX() {
        return localizacionX;
    }

    public void setLocalizacionX(double localizacionX) {
        this.localizacionX = localizacionX;
    }

    public double getLocalizacionY() {
        return localizacionY;
    }

    public void setLocalizacionY(double localizacionY) {
        this.localizacionY = localizacionY;
    }

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
        return "Vehiculo{" + "nombreConductor=" + nombreConductor + ", nPasajeros=" + nPasajeros + ", nMaximoPasajeros=" + nMaximoPasajeros + ", cantidadDinero=" + cantidadDinero + ", localizacionX=" + localizacionX + ", localizacionY=" + localizacionY + ", aireAcondicionadoActivado=" + aireAcondicionadoActivado + ", motorEncendido=" + motorEncendido + ", wifiEncendido=" + wifiEncendido + ", enMarcha=" + enMarcha + ", puertaAbierta=" + puertaAbierta + '}';
    }
    
    

}
