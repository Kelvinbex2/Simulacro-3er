package es.madrid.parla.dam.prog.Modelo;

public class Invitado  extends Cliente{
    public static String PUESTO = "Invitado";

    public Invitado(){
        
    }

    public Invitado(String nombre, String apellidos, String dirreccion, int telefono) {
        super(nombre, apellidos, dirreccion, telefono);
        //TODO Auto-generated constructor stub
    }
    

    
    public void mostrar() {
        System.out.println(PUESTO + " " +  nombre + " " + apellidos + " " + dirrexcion + "  " + numTarjeta);
    
    }
}
