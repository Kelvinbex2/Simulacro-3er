package es.madrid.parla.dam.prog.Ticket;

import es.madrid.parla.dam.prog.Modelo.Invitado;
import es.madrid.parla.dam.prog.Modelo.Personal;
import es.madrid.parla.dam.prog.Modelo.Producto;
import es.madrid.parla.dam.prog.Modelo.Socio;
import es.madrid.parla.dam.prog.Modelo.Supermercados;
import es.madrid.parla.dam.prog.entrada.Entrada;

public class Ticket {
    Supermercados supermercados = new Supermercados();


    public void resumen() {
        double total = 0.0;
        String id = "";
        String nombreCompleto = "";
        String tarjeta = "";

        // Recorrer la lista de personal del supermercado
        for (Personal personal : supermercados.getPersonales()) {

            if (personal instanceof Socio) {
                Socio socio = (Socio) personal;
                id = socio.getIdSocio();
                nombreCompleto = socio.getNombre() + " " + socio.getApellidos();

                System.out.println(id);
                System.out.println(nombreCompleto);

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
            } else {
                nombreCompleto = ((Invitado) personal).getNombre() + " " + ((Invitado) personal).getApellidos();
                System.out.println("Compra como invitado");
            }

            System.out.println(tarjeta.isEmpty() ? "No especificada" : tarjeta);

            // Recorrer la lista de productos del supermercado
            for (Producto producto : supermercados.getProductos()) {
                int cantidad = producto.getCantidad();
                String nombreProducto = producto.getNombre();
                double precioSinIva = producto.getPrecio();

                System.out.println(cantidad + " x " + nombreProducto + " - Precio sin IVA: " + precioSinIva);

                System.out.println("1. IVA Normal");
                System.out.println("2. IVA Reducido");
                System.out.println("3. IVA Superreducido");
                System.out.print("Seleccione el tipo de IVA: ");
                int opt = Entrada.leerEntero();

                double subtotalConIva = producto.calcularPrecioIVa(opt);
                double totalConIva = cantidad * subtotalConIva;
                total += totalConIva;

                // Mostrar detalle del producto en la compra
                System.out.println("Subtotal con IVA: " + subtotalConIva);
            }
        }

        System.out.println("TOTAL DE LA COMPRA: " + total);
    }

}
