package org.example.objetos;

public class Venta {
    private String nombre;
    private int cantidad;
    private String fecha;

    public Venta(String nombre, int cantidad, String fecha) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return nombre + ", " + cantidad + ", " + fecha;
    }
}
