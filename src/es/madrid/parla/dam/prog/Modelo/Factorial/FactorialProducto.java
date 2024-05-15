package es.madrid.parla.dam.prog.Modelo.Factorial;

import es.madrid.parla.dam.prog.Modelo.Articulos;
import es.madrid.parla.dam.prog.Modelo.Producto;
import es.madrid.parla.dam.prog.Modelo.Servicio;

public class FactorialProducto {
    public static Producto crearProducto(int opc) {
        switch (opc) {
            case 1:
                return new Articulos();
            case 2:
                return new Servicio();
            default:
                throw new IllegalArgumentException("Opción de partido no válida");
        }
    }
}
