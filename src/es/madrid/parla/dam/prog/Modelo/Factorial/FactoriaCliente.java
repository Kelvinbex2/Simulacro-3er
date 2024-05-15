package es.madrid.parla.dam.prog.Modelo.Factorial;
import es.madrid.parla.dam.prog.Modelo.Cliente;
import es.madrid.parla.dam.prog.Modelo.Invitado;
import es.madrid.parla.dam.prog.Modelo.Socio;

public class FactoriaCliente {
    public static Cliente crearProducto(int opc) {
        switch (opc) {
            case 1:
                return new Socio();
            case 2:
                return new Invitado();
            default:
                throw new IllegalArgumentException("Opción de partido no válida");
        }
    }
}
