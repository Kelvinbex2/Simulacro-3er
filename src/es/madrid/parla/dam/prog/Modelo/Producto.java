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

    public void calcularPrecioIVa(int opc) {
       
        if (opc == 1) {
            this.precio = calcularPrecio() * Iva.IVANORMAL;
        } else if (opc == 2) {
            this.precio = calcularPrecio()  * Iva.IVAREDUCIDO;
        } else if (opc == 3) {
            this.precio = calcularPrecio()  * Iva.IVASUPERREDUCIDO;
        } else {
            System.out.println("No se ha seleccionado ninguna opción");
        }

    }

    public double calcularPrecio(){
      return  this.precio = precio *cantidad;
    }

    public void calcularPrecioSinIva

    public void mostrarProducto() {
        System.out.println("Producto antes el iva: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Precio: " + precio);

    }

}
