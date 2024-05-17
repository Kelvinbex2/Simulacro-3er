package es.madrid.parla.dam.prog.Modelo;

public class Producto {
    private String nombre;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto() {
    }

    public Producto(String nombre, String descripcion, double precio, int cantidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double calcularPrecioIVa(int opc) {
        double preciosIva = 0.0;
        double total = calcularPrecioSinIva();
        if (opc == 1) {
            preciosIva = total + (total * Iva.IVANORMAL);
        } else if (opc == 2) {
            preciosIva = total + (total * Iva.IVAREDUCIDO);
        } else if (opc == 3) {
            preciosIva = total + (total * Iva.IVASUPERREDUCIDO);
        } else {
            System.out.println("No se ha seleccionado ninguna opción");
        }
        return preciosIva;
    }

    public double calcularPrecioSinIva() {
        return this.precio = precio * cantidad;
    }

}
