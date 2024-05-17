package es.madrid.parla.dam.prog.Modelo;

import java.time.format.DateTimeFormatter;

public class Socio extends Cliente {
    public static String TIPO = "Soy socio";
    private String idSocio;
    private String fechaInscripcion;

    public Socio() {

    }

    public Socio(String nombre, String apellidos, String dirreccion, String numTarjeta, String fechaInscripcion) {
        super(nombre, apellidos, dirreccion, numTarjeta);
        this.fechaInscripcion = fechaInscripcion;
        this.idSocio = crearid();
    }


    public String getIdSocio() {
        return idSocio;
    }

    public void setIdSocio(String idSocio) {
        this.idSocio = idSocio;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public String crearid() {

        String[] sco = nombre.split(" ");
        String id = sco[sco.length - 1];
        String generar = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = fechaInscripcion.formatted(formater);

        return generar + "-" + date;

    }

    

}
