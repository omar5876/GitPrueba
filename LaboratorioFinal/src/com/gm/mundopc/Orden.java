
package com.gm.mundopc;


public class Orden {
    private final int idOrden;
    private Computadora computadoras [];
    private static int contadorOrdenes;
    private int contadorComputadoras;
    private final static int MAX = 10;
    
    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.computadoras = new Computadora[Orden.MAX];
        
    }
    public void agregarComputadoras(Computadora computadora){
        if (this.contadorComputadoras < Orden.MAX) {
            this.computadoras[this.contadorComputadoras++] = computadora;
        }else{
            System.out.println("Orden llena");
        }
    }
    
    public void mostrarOrden(){
        System.out.println("ID: " + this.idOrden);
        for (int i = 0; i < this.contadorComputadoras; i++) {
            System.out.println(this.computadoras[i]);
        }
    }
}
