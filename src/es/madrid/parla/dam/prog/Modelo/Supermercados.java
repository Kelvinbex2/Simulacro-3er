package es.madrid.parla.dam.prog.Modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import es.madrid.parla.dam.prog.entrada.Entrada;

public class Supermercados {
    private String nombre;
    private String dirreccion;
    private String cif;
    private LocalDate date;
    private List<Personal> personales;
    private List<Producto> productos;


    public Supermercados(String nombre, String dirreccion, LocalDate date) {
        this.nombre = nombre;
        this.dirreccion = dirreccion;
        this.cif = crearid();
        this.date = date;
        this.personales = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDirreccion() {
        return dirreccion;
    }

    public void setDirreccion(String dirreccion) {
        this.dirreccion = dirreccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public List<Personal> getPersonales() {
        return personales;
    }

    public void setPersonales(List<Personal> personales) {
        this.personales = personales;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void agregarPersonal(Personal person) {
        if (personales.size() < 30) {
            personales.add(person);
        } else {
            System.out.println("Solo puedes agregar 30 empleados");
        }

    }

    public void eliminar(Personal nombre2) {
        if (personales.isEmpty()) {
            System.out.println("No hay Personal");
        } else {
            personales.remove(nombre2);
        }

    }

    public void agregarProducto(Producto producto) {

        productos.add(producto);

    }

    public void eliminarProd(Producto producto) {
        if (!productos.isEmpty()) {

            productos.remove(producto);
        }
    }

    public String crearid() {
        String dates = "2020-05-01";
        String[] emp = nombre.split(" ");
        String id = emp[emp.length - 1];
        String generar = id.substring(0, Math.min(id.length(), 4)).toUpperCase();

        DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = dates.formatted(formater);

        return generar + "-" + date;

    }

    public void generar() {

        for (Personal personal : personales) {
            if (personal instanceof Socio) {
                ((Socio) personales).mostrar();
            } else if (personal instanceof Invitado) {
                ((Invitado) personales).mostrar();
            }
            {

            }
        }
    }

    public void calcularPrecioIVa(){
        System.out.println("Elege el Iva: ");
        int opc = Entrada.leerEntero();
        for (Producto producto : productos) {
            producto.calcularPrecioIVa(opc);
        }
    }

 
}
