
package com.gm.mundopc;


public class Monitor {
    private final int idMonitores;
    private String marca;
    private double tamano;
    private static int contadorMonitores;

    private Monitor() {
        this.idMonitores = ++Monitor.contadorMonitores;
    }

    public Monitor(String marca, double tamano) {
        this();
        this.marca = marca;
        this.tamano = tamano;
    }
    public int getIdMonitores(){
        return this.idMonitores;
    }
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getTamano() {
        return tamano;
    }

    public void setTamano(double tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Monitor{" + "idMonitores=" + idMonitores + ", marca=" + marca + ", tamano=" + tamano + '}';
    }
    
    
    
    
    
}
