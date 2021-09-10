
package test;

import domain.Pedido;
import domain.Restaurante;


public class Test {
    public static void main(String[] args) {
        Pedido p1 = new Pedido("1", "642410", 1000, 01, 03, 1982);
        
        Pedido p2 = new Pedido("2", "64", 3000, 12, 04, 1987);
        
        Restaurante restaurante = new Restaurante();
        restaurante.agregarPedidoLista(p1);
        restaurante.agregarPedidoLista(p2);
        System.out.println(restaurante.calcularGanancias());
        System.out.println("Desviacion Estandar = " + restaurante.desviacionEstandarGananciasTotales());
        
        System.out.println("Costo pedido 2 " + restaurante.retornarCostoPedido("64"));
        
        restaurante.imprmir();
        
        
        
    }
}
