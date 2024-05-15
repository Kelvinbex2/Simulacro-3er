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
    
    public static Empleado crearEmpleado(int opc){
        if (opc==1) {
            return new Fruteria();
        }else if (opc==2) {
            return new Pescadaria();
        }else if(opc==3){
            return new Bazar();
        }else if(opc==4){
            return new Carniceria();
        }else if(opc==5){
            return new Electrodomestico();
        }else if (opc==6) {
            return new Frescos();
        }else{
            return new Limpieza();
        }
    }
}
