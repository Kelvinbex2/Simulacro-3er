package es.madrid.parla.dam.prog.Modelo;

public class Cliente extends Personal {
    protected String dirrexcion;
    protected String numTarjeta;

    public Cliente(String nombre, String apellidos, String dirreccion, String numTarjeta) {
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

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public  String formatearUltimosDigitos(String num) {
        String ultimosCuatroDigitos = numTarjeta.substring(numTarjeta.length() - 4);
        
        // Crear el formato deseado
        String formatoDeseado = "**** **** **** " + ultimosCuatroDigitos;
        
        return formatoDeseado;
    }

}
