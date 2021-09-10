
package test;

import domain.*;


public class Test {
    public static void main(String[] args) {
        Autobus a = new Autobus("Pepe", 30);
        System.out.println("Autobus " + a);
        
        a.recogerPasajero(2);
        System.out.println("Autobus " + a);
        
        a.gestionarPuerta();
        a.gestionarMarcha();
        System.out.println("Autobus " + a);
        
        a.recogerPasajero(2);
        a.gestionarMarcha();
        a.gestionarPuerta();
        System.out.println("Autobus " + a);
        
        a.moverArriba(2);
        a.moverDerecha(5);
        a.gestionarWifi();
        a.gestionarAireAcondicionado();
        System.out.println("Autobus " + a);
        
        a.gestionarMotor();
        a.moverIzquierda(2);
        System.out.println("Autobus " + a);
        
        System.out.println("--------------------------------------------------");
        Taxi b = new Taxi("Pepe");
        System.out.println("Taxi " + b);
        
        b.gestionarMotor();
        b.gestionarMarcha();
        b.recogerPasajero();
        System.out.println("Taxi " + b);
        
        b.gestionarMarcha();
        b.recogerPasajero();
        b.moverArriba(10);
        b.moverDerecha(12);
        b.gestionarSeguros();
        b.moverAbajo(10);
        b.moverIzquierda(12);
        System.out.println("Taxi " + b);
        
        b.gestionarAireAcondicionado();
        b.gestionarWifi();
        b.gestionarMotor();
        b.presionarBotonPanico();
        System.out.println("Taxi " + b);
    }
}
