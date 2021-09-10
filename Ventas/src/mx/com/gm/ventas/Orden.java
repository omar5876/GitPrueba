
package mx.com.gm.ventas;


public class Orden {
    private int idOrden;
    private Producto productos [];
    private static int contadorOrdenes;
    private int contadorProductos;
    private final static int MAX = 10;

    public Orden() {
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto [Orden.MAX];
        this.contadorProductos = contadorProductos;
    }
    public void agregarProducto(Producto producto){
        if (this.contadorProductos < Orden.MAX) {
            this.productos[this.contadorProductos++] = producto;
        }else{
            System.out.println("Se ha superado el numero maximo de productos: " + Orden.MAX);
        }
    }
    
    public double calcularTotal(){
        double suma=0;
        for (int i = 0; i < this.contadorProductos; i++) {
            Producto producto = this.productos[i];
            suma += producto.getPrecio();
        }
        return suma;
    }
    
    public void mostrar(){
        System.out.println("ID "+ this.idOrden);
        System.out.println("Total de la orden: " + this.calcularTotal());
        System.out.println("Productos: ");
        for (int i = 0; i < this.contadorProductos; i++) {
            System.out.println(this.productos[i]);
        }
    }
}
