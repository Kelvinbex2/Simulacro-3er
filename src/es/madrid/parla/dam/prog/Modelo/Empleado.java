package es.madrid.parla.dam.prog.Modelo;

public class Empleado extends Personal {
    private String direccion;
    private int telefono;

    public Empleado() {
        
    }

    public Empleado(String nombre, String apellidos,String dirrecion,int telefono) {
        super(nombre, apellidos);
        this.direccion=dirrecion;
        this.telefono=telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    
}
