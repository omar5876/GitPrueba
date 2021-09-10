
package com.gm.mundopc;


public class Teclado extends DispositivoEntrada{
    private final int idTeclados;
    private static int contadorTeclados;

    public Teclado(String tipoEntrada, String marca) {
        super(tipoEntrada, marca);
        this.idTeclados = ++Teclado.contadorTeclados;
    }

    @Override
    public String toString() {
        return "Teclado{" + "idTeclados=" + idTeclados + '}' + super.toString();
    }
    
    
    
}
