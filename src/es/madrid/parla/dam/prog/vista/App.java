package es.madrid.parla.dam.prog.vista;

import java.time.LocalDate;
import java.util.ArrayList;

import es.madrid.parla.dam.prog.Modelo.Articulos;
import es.madrid.parla.dam.prog.Modelo.Bazar;
import es.madrid.parla.dam.prog.Modelo.Carniceria;
import es.madrid.parla.dam.prog.Modelo.Electrodomestico;
import es.madrid.parla.dam.prog.Modelo.Empleado;
import es.madrid.parla.dam.prog.Modelo.Frescos;
import es.madrid.parla.dam.prog.Modelo.Fruteria;
import es.madrid.parla.dam.prog.Modelo.Invitado;
import es.madrid.parla.dam.prog.Modelo.Limpieza;
import es.madrid.parla.dam.prog.Modelo.Personal;
import es.madrid.parla.dam.prog.Modelo.Pescadaria;
import es.madrid.parla.dam.prog.Modelo.Producto;
import es.madrid.parla.dam.prog.Modelo.Servicio;
import es.madrid.parla.dam.prog.Modelo.Socio;
import es.madrid.parla.dam.prog.Modelo.Supermercados;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactoriaCliente;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactoriaP;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactorialEmpleado;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactorialProducto;
import es.madrid.parla.dam.prog.Ticket.Ticket;
import es.madrid.parla.dam.prog.entrada.Entrada;

public class App {
    static Supermercados supers;
    static ArrayList<Supermercados> sup = new ArrayList<>();
    static Ticket ticket = new Ticket();

    public static void main(String[] args) throws Exception {
        menu();
    }

    public static void menu() {
        int opc = 0;
        do {
            System.out.println("1. Crear supermercado");
            System.out.println("2. Crear personal(Cliente y EMpleados)");
            System.out.println("3. Eliminar empleados");
            System.out.println("4. Crear producto");
            System.out.println("5. Eliminar producto");
            System.out.println("6. Generar Ticket");
            System.out.println("0. Salir");
            System.out.println("Elegir una opcion");
            opc = Entrada.leerEntero();
            switch (opc) {
                case 1:
                    crearSupermercado();
                    break;
                case 2:
                    crearPersonal();
                    break;
                case 3:
                    eliminarEmpleado();
                    break;
                case 4:
                    agregarProducto();
                    break;
                case 5:
                    eliminarProd();

                case 6:
                    ticket.resumen();
                    break;

                case 0:
                    System.out.println("Hasta luego!");
                    break;

                default:
                    break;
            }
        } while (opc != 0);

    }

    public static void crearSupermercado() {
        System.out.println("Introduce el nombre del supermercado: ");
        String nombre = Entrada.leerString();
        System.out.println("Introduce la direccion del supermercado: ");
        String dirreccion = Entrada.leerString();
        System.out.println("Introduce la fecha de fundacion del supermercado: ");
        LocalDate date = crearDate();
        supers = new Supermercados(nombre, dirreccion, date);
        sup.add(supers);
    }

    public static LocalDate crearDate() {
        System.out.print("Anio: ");
        int anio = Entrada.leerEntero();
        System.out.print("Mes: ");
        int mes = Entrada.leerEntero();
        System.out.print("Dia: ");
        int dia = Entrada.leerEntero();
        return LocalDate.of(anio, mes, dia);
    }

    public static void crearPersonal() {
        Personal personal = null;
        System.out.println("1. Empleado \n2. Cliente");
        int opc = Entrada.leerEntero();
        FactoriaP.crearPersonal(opc);
        if (FactoriaP.crearPersonal(opc) instanceof Empleado && opc == 1) {
            System.out.print("Introduce el nombre del Empleado: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el apellido del Empleado: ");
            String apellido = Entrada.leerString();
            System.out.print("Introduce el telefono del Empleado: ");
            int telefono = Entrada.leerEntero();
            System.out.print("Introduce la direccion del Empleado: ");
            String direccion = Entrada.leerString();

            System.out.println(
                    "1.Fruteria \n2.Pescaderia \n3.Bazar \n4.Caniceria \n5.Electrodomesticos \n6.Frescos \n7.Limpieza");
            System.out.print("Elige una opcion: ");
            int opcion = Entrada.leerEntero();

            FactorialEmpleado.crearEmpleado(opcion);

            if (FactorialEmpleado.crearEmpleado(opcion) instanceof Fruteria && opcion == 1) {
                personal = new Fruteria(nombre, apellido, direccion, telefono);

            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Pescadaria && opcion == 2) {
                personal = new Pescadaria(nombre, apellido, direccion, telefono);

            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Bazar && opcion == 3) {
                personal = new Bazar(nombre, apellido, direccion, telefono);

            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Carniceria && opcion == 4) {
                personal = new Carniceria(nombre, apellido, direccion, telefono);

            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Electrodomestico && opcion == 5) {
                personal = new Electrodomestico(nombre, apellido, direccion, telefono);
            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Frescos && opcion == 6) {
                personal = new Frescos(nombre, apellido, direccion, telefono);
            } else if (FactorialEmpleado.crearEmpleado(opcion) instanceof Limpieza && opcion == 7) {
                personal = new Limpieza(nombre, apellido, direccion, telefono);
            }

        } else {
            System.out.print("1.Socio\n2.Invitado\nElegir una: ");
            int opc3 = Entrada.leerEntero();

            FactoriaCliente.crearProducto(opc3);

            System.out.print("Introduce el nombre del cliente: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el apellido del cliente: ");
            String apellido = Entrada.leerString();
            System.out.println("Introduce el dirrecion del cliente: ");
            String direccion = Entrada.leerString();
            System.out.println("Introduce el numTarjeta del cliente: ");
            String numTarjeta = Entrada.leerString();
            System.out.println("Introduce la Fecha de inscripcion: ");
            String fechaInscripcion = Entrada.leerString();

            if (FactoriaCliente.crearProducto(opc3) instanceof Socio ) {

                personal = new Socio(nombre, apellido, direccion, numTarjeta, fechaInscripcion);
            } else {
                personal = new Invitado(nombre, apellido, direccion, numTarjeta);
            }
        }
        supers.agregarPersonal(personal);
    }

    public static void eliminarEmpleado() {
        System.out.print("Introduce el nombre del empleado a eliminar: ");
        String nombre = Entrada.leerString();
        boolean empleadoEliminado = false;

        for (Personal p : supers.getPersonales()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                supers.eliminar(p);
                empleadoEliminado = true;
                break;
            }
        }

        if (!empleadoEliminado) {
            System.out.println("Empleado no encontrado.");
        }
    }

    public static void eliminarProd() {
        System.out.print("Escribe el nombre del producto a eliminar: ");
        String nombre = Entrada.leerString();
        boolean productoEliminado = false;

        for (Producto p : supers.getProductos()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                supers.eliminarProd(p);
                productoEliminado = true;
                break;
            }
        }

        if (!productoEliminado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void agregarProducto() {
        Producto producto = null;
        System.out.print("1.Articulos \n2.Servicio \nElegir una opcion: ");
        int opcion = Entrada.leerEntero();
        FactorialProducto.crearProducto(opcion);
        if (FactorialProducto.crearProducto(opcion) instanceof Articulos && opcion == 1) {
            System.out.print("Introduce el nombre del articulo: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el precio del articulo: ");
            double precio = Entrada.leerDouble();
            System.out.print("Introduce la cantidad del articulo: ");
            int cantidad = Entrada.leerEntero();
            producto = new Articulos(nombre, nombre, precio, cantidad);

        } else {
            System.out.print("Introduce el nombre del servicio: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el precio del servicio: ");
            double precio = Entrada.leerDouble();
            System.out.print("Introduce la cantidad del servicio: ");
            int cantidad = Entrada.leerEntero();
            producto = new Servicio(nombre, nombre, precio, cantidad);
        }
        supers.agregarProducto(producto);

    }

}
