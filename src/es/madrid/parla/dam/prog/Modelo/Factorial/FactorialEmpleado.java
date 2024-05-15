package es.madrid.parla.dam.prog.Modelo.Factorial;

import es.madrid.parla.dam.prog.Modelo.Bazar;
import es.madrid.parla.dam.prog.Modelo.Carniceria;
import es.madrid.parla.dam.prog.Modelo.Electrodomestico;
import es.madrid.parla.dam.prog.Modelo.Empleado;
import es.madrid.parla.dam.prog.Modelo.Frescos;
import es.madrid.parla.dam.prog.Modelo.Fruteria;
import es.madrid.parla.dam.prog.Modelo.Limpieza;
import es.madrid.parla.dam.prog.Modelo.Pescadaria;

public class FactorialEmpleado {
    public static Empleado crearEmpleado(int opc) {
        switch (opc) {
            case 1:
                return new Fruteria();
            case 2:
                return new Pescadaria();
            case 3:
                return new Bazar();
            case 4:
                return new Carniceria();
            case 5:
                return new Electrodomestico();
            case 6:
                return new Frescos();
            case 7:
                return new Limpieza();
            default:
                throw new IllegalArgumentException("Opción de empleado no válida");
        }
    }


}
