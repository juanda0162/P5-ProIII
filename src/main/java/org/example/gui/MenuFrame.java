package org.example.gui;

import org.example.objetos.ListaDoble;
import org.example.objetos.Venta;

import javax.swing.*;
import java.awt.*;

public class MenuFrame extends JFrame {
    private JLabel nombreLabel;
    private JTextArea ventasTextArea; // Agregado

    private JButton verInfoButton;
    private JButton ventaButton;

    public MenuFrame(String nombre) {
        super("Menu Frame");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(300, 200);
        setLayout(new BorderLayout());

        nombreLabel = new JLabel("Persona: " + nombre);
        nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nombreLabel.setVerticalAlignment(SwingConstants.CENTER);
        nombreLabel.setFont(nombreLabel.getFont().deriveFont(24.0f));
        add(nombreLabel, BorderLayout.NORTH);

        ventasTextArea = new JTextArea(); // Agregado
        add(new JScrollPane(ventasTextArea), BorderLayout.CENTER); // Agregado

        verInfoButton = new JButton("Ver Info");
        ventaButton = new JButton("Venta");


        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(verInfoButton);
        buttonPanel.add(ventaButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JButton getVerInfoButton() {
        return verInfoButton;
    }

    public JButton getVentaButton() {
        return ventaButton;
    }

    public JTextArea getVentasTextArea() {
        return ventasTextArea;
    }
    public void mostrarVentas(ListaDoble<Venta> ventas, JTextArea textArea) {
        textArea.setText("");
        for (Venta venta : ventas) {
            String infoVenta = "Nombre: " + venta.getNombre() + ", Cantidad: " + venta.getCantidad() + ", Fecha: " + venta.getFecha();
            textArea.append(infoVenta + "\n");
        }
        textArea.setEditable(false);
    }
}