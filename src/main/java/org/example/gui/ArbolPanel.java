package org.example.gui;

import org.example.archivos.LectorVentas;
import org.example.objetos.Arbol;
import org.example.objetos.ListaDoble;
import org.example.objetos.Venta;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class ArbolPanel extends JPanel implements MouseListener {
    private Arbol<String> modelo;
    private DibujoArbol dibujo;


    public ArbolPanel(Arbol<String> modelo) {
        this.modelo = modelo;
        this.dibujo = new DibujoArbol(modelo);
        this.addMouseListener(this);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujo.dibujar(g);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600,500);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int xClic = e.getX();
        int yClic = e.getY();

        String nombreNodo = dibujo.obtenerNodoClic(xClic, yClic);
        if (nombreNodo != null) {
            MenuFrame menuFrame = new MenuFrame(nombreNodo);

            menuFrame.getVerInfoButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String nombrePersona = nombreNodo;

                    // Obtener las ventas de la persona seleccionada
                    ListaDoble<Venta> ventasPersona = obtenerVentasPersona(nombrePersona);

                    // Mostrar las ventas en el JTextArea del MenuFrame
                    menuFrame.mostrarVentas(ventasPersona, menuFrame.getVentasTextArea());
                }

            });

            menuFrame.getVentaButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Acción cuando se presiona el botón "Venta"
                    System.out.println("Venta");
                }
            });

            menuFrame.setVisible(true);
        }


    }


    private ListaDoble<Venta> obtenerVentasPersona(String nombrePersona) {
        File archivoVentas = new File("D:\\\\Users new\\\\Escritorio\\\\ventas.txt"); // Reemplaza "ruta_archivo_ventas.txt" con la ruta correcta del archivo de ventas

        try {
            LectorVentas lectorVentas = new LectorVentas(archivoVentas);
            ListaDoble<Venta> ventas = lectorVentas.leer();

            ListaDoble<Venta> ventasPersona = new ListaDoble<>();
            for (Venta venta : ventas) {
                if (venta.getNombre().equals(nombrePersona)) {
                    ventasPersona.agregar(venta);
                }
            }

            return ventasPersona;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}