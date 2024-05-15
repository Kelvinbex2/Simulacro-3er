package es.madrid.parla.dam.prog.Ticket;

import java.util.ArrayList;

import es.madrid.parla.dam.prog.Modelo.Iva;
import es.madrid.parla.dam.prog.Modelo.Personal;
import es.madrid.parla.dam.prog.Modelo.Producto;
import es.madrid.parla.dam.prog.Modelo.Supermercados;

public class Ticket {
    private ArrayList <Supermercados> supermercados;
    Iva iva = new Iva();

    public Ticket() {
        this.supermercados = new ArrayList<>();
    }

    

    public ArrayList<Supermercados> getSupermercados() {
        return supermercados;
    }

    public void setSupermercados(ArrayList<Supermercados> supermercados) {
        this.supermercados = supermercados;
    }


    public void resumen(){
        System.out.println("Resumen de la compra");
        for (Supermercados supermercado : supermercados) {
            System.out.println("Supermercado: " + supermercado.getNombre() + " CIF: " + supermercado.getCif() + " Direccion: " + supermercado.getDirreccion());
            for (Producto producto : supermercado.getProductos()) {
                
                
        }
    }
  
}
