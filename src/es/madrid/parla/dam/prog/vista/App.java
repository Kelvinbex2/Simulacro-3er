package es.madrid.parla.dam.prog.vista;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import es.madrid.parla.dam.prog.Modelo.Articulos;
import es.madrid.parla.dam.prog.Modelo.Bazar;
import es.madrid.parla.dam.prog.Modelo.Carniceria;
import es.madrid.parla.dam.prog.Modelo.Cliente;
import es.madrid.parla.dam.prog.Modelo.Electrodomestico;
import es.madrid.parla.dam.prog.Modelo.Empleado;
import es.madrid.parla.dam.prog.Modelo.Frescos;
import es.madrid.parla.dam.prog.Modelo.Fruteria;
import es.madrid.parla.dam.prog.Modelo.Invitado;
import es.madrid.parla.dam.prog.Modelo.Limpieza;
import es.madrid.parla.dam.prog.Modelo.Personal;
import es.madrid.parla.dam.prog.Modelo.Pescadaria;
import es.madrid.parla.dam.prog.Modelo.Producto;
import es.madrid.parla.dam.prog.Modelo.Socio;
import es.madrid.parla.dam.prog.Modelo.Supermercados;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactoriaCliente;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactorialEmpleado;
import es.madrid.parla.dam.prog.Modelo.Factorial.FactorialProducto;
import es.madrid.parla.dam.prog.entrada.Entrada;

public class App {
    static Supermercados supers;
    static ArrayList<Supermercados> sup = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        supers = new Supermercados("Nom", "ss", crearDate());
        sup.add(supers);
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
                    venta();
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

        if (opc == 1) {
            System.out.print("Introduce el nombre del Empleado: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el apellido del Empleado: ");
            String apellido = Entrada.leerString();
            System.out.print("Introduce el telefono del Empleado: ");
            int telefono = Entrada.leerEntero();
            System.out.print("Introduce la direccion del Empleado: ");
            String direccion = Entrada.leerString();

            System.out.println(
                    "1. Fruteria \n2. Pescaderia \n3. Bazar \n4. Carniceria \n5. Electrodomesticos \n6. Frescos \n7. Limpieza");
            System.out.print("Elige una opcion: ");
            int opcion = Entrada.leerEntero();

            Empleado empleado = FactorialEmpleado.crearEmpleado(opcion);
            empleado.setNombre(nombre);
            empleado.setApellidos(apellido);
            empleado.setDireccion(direccion);
            empleado.setTelefono(telefono);

            personal = empleado;
        } else if (opc == 2) {
            System.out.print("1. Socio\n2. Invitado\nElegir una: ");
            int opc3 = Entrada.leerEntero();

            System.out.print("Introduce el nombre del cliente: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el apellido del cliente: ");
            String apellido = Entrada.leerString();
            System.out.print("Introduce el dirrecion del cliente: ");
            String direccion = Entrada.leerString();
            System.out.print("Introduce el numTarjeta del cliente: ");
            String numTarjeta = Entrada.leerString();
            while (numTarjeta.length() > 16) {
                System.out.println("No puedes introduicr un numero mayor que 16");
                System.out.print("Introduce el numTarjeta del cliente: ");
                numTarjeta = Entrada.leerString();
            }
            System.out.print("Introduce la Fecha de inscripcion <yyyy-MM-dd>: ");
            String fechaInscripcion = Entrada.leerString();

            Cliente cliente = FactoriaCliente.crearCliente(opc3);
            cliente.setNombre(nombre);
            cliente.setApellidos(apellido);
            cliente.setDirrexcion(direccion);
            cliente.setNumTarjeta(numTarjeta);

            if (cliente instanceof Socio) {
                Socio socio = (Socio) cliente;
                socio.setFechaInscripcion(fechaInscripcion);
            }

            personal = cliente;
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

        System.out.print("1. Articulos\n2. Servicio\nElige una opción: ");
        int opcion = Entrada.leerEntero();

        // Utilizar la factorial para crear el tipo de producto seleccionado
        producto = FactorialProducto.crearProducto(opcion);

        if (producto != null && producto instanceof Articulos) {
            // Pedir los detalles específicos del producto al usuario

            System.out.print("Introduce el nombre del producto: ");
            String nombre = Entrada.leerString();
            System.out.print("Introduce el precio del producto: ");
            double precio = Entrada.leerDouble();
            System.out.print("Introduce la cantidad del producto: ");
            int cantidad = Entrada.leerEntero();

            // Establecer los detalles del producto creado
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidad(cantidad);

            // Agregar el producto al supermercado (supers)
            supers.agregarProducto(producto);
            System.out.println("Producto agregado con éxito.");
        } else {
            System.out.println("Opción inválida. No se pudo agregar el producto.");
        }
    }

    public static void venta() {
        double total = 0.0;
        String id = "";
        String nombreCompleto = "";
        String tarjeta = "";
        String nomEmp = "";
        String puesto = "";
        double subtotalConIva = 0;
        double totalConIva = 0;
        int cantidad = 0;
        String nombreProducto = "";
        double precioSinIva = 0;

        // Recorrer la lista de personal del supermercado
        for (Personal personal : supers.getPersonales()) {
            if (personal instanceof Socio) {
                Socio socio = (Socio) personal;
                id = socio.crearid();
                nombreCompleto = socio.getNombre() + " " + socio.getApellidos();

                System.out.println("1. Tarjeta");
                System.out.println("2. Efectivo");
                System.out.print("Seleccione la forma de pago: ");

                int opc = Entrada.leerEntero();

                if (opc == 1) {
                    System.out.println("Has elegido pagar con tarjeta.");
                    tarjeta = socio.getNumTarjeta();
                    // Formatear los últimos 4 dígitos de la tarjeta
                    tarjeta = socio.formatearUltimosDigitos(tarjeta);
                } else if (opc == 2) {
                    System.out.println("Has elegido pagar en efectivo.");
                }
            } else if (personal instanceof Invitado) {
                Invitado invitado = (Invitado) personal;
                nombreCompleto = invitado.getNombre() + " " + invitado.getApellidos();
                System.out.println("Compra como invitado");
            }

            if (personal instanceof Empleado) {
                Empleado em = (Empleado) personal;
                nomEmp = em.getNombre();

                if (personal instanceof Bazar) {
                    puesto = Bazar.PUESTO;
                } else if (personal instanceof Carniceria) {
                    puesto = Carniceria.PUESTO;
                } else if (personal instanceof Electrodomestico) {
                    puesto = Electrodomestico.PUESTO;
                } else if (personal instanceof Frescos) {
                    puesto = Frescos.PUESTO;
                } else if (personal instanceof Fruteria) {
                    puesto = Fruteria.PUESTO;
                } else if (personal instanceof Limpieza) {
                    puesto = Limpieza.PUESTO;
                } else {
                    puesto = Pescadaria.PUESTO;
                }
            }

            // Recorrer la lista de productos del supermercado
            for (Producto producto : supers.getProductos()) {
                cantidad = producto.getCantidad();
                nombreProducto = producto.getNombre();
                precioSinIva = producto.getPrecio();

                System.out.println("1. IVA Normal");
                System.out.println("2. IVA Reducido");
                System.out.println("3. IVA Superreducido");
                System.out.print("Seleccione el tipo de IVA para " + nombreProducto + ": ");
                int opt = Entrada.leerEntero();

                subtotalConIva = producto.calcularPrecioIVa(opt);
                totalConIva = subtotalConIva;
                total += totalConIva;

            }
        }

        // Mostrar resumen de la compra
        System.out.println("********************************************");
        System.out.println("ID del Socio: " + id);
        System.out.println("Nombre del Cliente: " + nombreCompleto);
        System.out.println("Tarjeta de Crédito: " + (tarjeta.isEmpty() ? "No especificada" : tarjeta));
        System.out.println(cantidad + " x " + nombreProducto + " - Precio sin IVA: " + precioSinIva
                + " Subtotal con IVA: " + totalConIva);
        System.out.println("TOTAL DE LA COMPRA: " + total);
        System.out.println("Atendido por: " + nomEmp + " - Zona: " + puesto);
        System.out.println("********************************************");

        String nombreArchivo = "Ticke.txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo));
            writer.write("ID del Socio: " + id + "\n");
            writer.write("Nombre del Cliente: " + nombreCompleto + "\n");
            writer.write("Tarjeta de Credito: " + (tarjeta.isEmpty() ? "No especificada" : tarjeta) + "\n");
            writer.write("TOTAL DE LA COMPRA: " + total + "\n");
            writer.write("Atendido por: " + nomEmp + " - Zona: " + puesto + "\n");

            System.out.println("Resumen de la compra guardado en el archivo: " + nombreArchivo);
            writer.close();
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

}
