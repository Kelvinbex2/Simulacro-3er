package es.madrid.parla.dam.prog.Modelo;

public class Cliente extends Personal {
    protected String dirrexcion;
    protected int numTarjeta;

    public Cliente(String nombre, String apellidos, String dirreccion, int numTarjeta) {
        super(nombre, apellidos);
        this.dirrexcion = dirreccion;
        this.numTarjeta = numTarjeta;
    }

    public Cliente() {

    }

    public String getDirrexcion() {
        return dirrexcion;
    }

    public void setDirrexcion(String dirrexcion) {
        this.dirrexcion = dirrexcion;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

}
