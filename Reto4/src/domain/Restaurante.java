package domain;

import java.util.ArrayList;

public class Restaurante {

    private ArrayList<Pedido> pedidos;

    public Restaurante() {
        this.pedidos = new ArrayList<Pedido>();
    }

    public void agregarPedidoLista(Pedido p) {
        boolean existe = false;
        for (Pedido pedido : this.pedidos) {
            if (pedido.getIDCliente().equals(p.getIDCliente())) {
                existe = true;
            } 
        }
        if (! existe) {
            pedidos.add(p);
        }
    }

    public void eliminarPedido(String npedido) {
        for (Pedido pedido : this.pedidos) {
            if (pedido.getnPedido().equals(npedido)) {
                this.pedidos.remove(pedido);
            }

        }

    }

    public double calcularGanancias() {
        double suma = 0;
        for (Pedido pedido : this.pedidos) {
            suma += pedido.getCostoPedido();
        }
        return suma;
    }

    public double promedioGananciasTotales() {
        double division = this.pedidos.size();
        return calcularGanancias() / division;
    }

    public double desviacionEstandarGananciasTotales() {
        double varianza = 0;
        for (Pedido pedido : this.pedidos) {
            varianza += Math.pow(pedido.getCostoPedido() - promedioGananciasTotales(), 2);
        }
        return Math.sqrt(varianza / this.pedidos.size());
    }

    public double retornarCostoPedido(String ID) {
        double costo = 0;
        for (Pedido pedido : this.pedidos) {
            if (pedido.getIDCliente().equals(ID)) {
                costo = pedido.getCostoPedido();
            }
        }
        return costo;
    }
    
    public void imprmir(){
        for (Pedido pedido: this.pedidos) {
            System.out.println("pedido = " + pedido);
        }
    }

    public ArrayList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

}
