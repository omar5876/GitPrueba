
package test;

import accesoDatos.*;


public class TestInterfaces {
    public static void main(String[] args) {
        IAccesoDatos datos = new ImplementacionMysql();
        imprmir(datos);
        
        datos = new implementacionOracle();
        imprmir(datos);
    }
    public static void imprmir(IAccesoDatos datos){
        datos.listar();
    }
}
