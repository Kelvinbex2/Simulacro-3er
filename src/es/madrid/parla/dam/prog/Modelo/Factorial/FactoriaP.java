package es.madrid.parla.dam.prog.Modelo.Factorial;

import es.madrid.parla.dam.prog.Modelo.Cliente;
import es.madrid.parla.dam.prog.Modelo.Empleado;
import es.madrid.parla.dam.prog.Modelo.Personal;

public class FactoriaP {


    public static Personal crearPartido(int opc) {
        switch (opc) {
            case 1:
                return new Empleado(); 
            case 2:
                return new Cliente(); 
            default:
                throw new IllegalArgumentException("Opción de partido no válida");
        }
    }
}
