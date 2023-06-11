package org.example.gui;




import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.archivos.LectorArbol;
import org.example.objetos.Arbol;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ArbolFrame extends JFrame {
    private Arbol<String> modelo;
    private static Logger logger = LogManager.getRootLogger();

    public ArbolFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.pack();
        this.setVisible(true);

    }



    public void cargarArbolDesdeArchivo(File archivo) {
        LectorArbol lector = new LectorArbol(archivo);
        try {
            modelo = lector.leer();
            ArbolPanel panel = new ArbolPanel(modelo);
            this.getContentPane().add(panel, BorderLayout.CENTER);
            this.setSize(getPreferredSize());
            this.setVisible(true);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo.");
        }
    }
}