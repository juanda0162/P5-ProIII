package org.example.archivos;


import org.example.objetos.ListaDoble;
import org.example.objetos.Venta;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LectorVentas {
    private File archivo;

    public LectorVentas(File archivo) {
        this.archivo = archivo;
    }

    public ListaDoble<Venta> leer() throws IOException {
        ListaDoble<Venta> ventas = new ListaDoble<>();

        BufferedReader br = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            if (partes.length == 3) {
                String nombre = partes[0].trim();
                int cantidad = Integer.parseInt(partes[1].trim());
                String fecha = partes[2].trim();
                Venta venta = new Venta(nombre, cantidad, fecha);
                ventas.agregar(venta);
            }
        }
        br.close();

        return ventas;
    }
}