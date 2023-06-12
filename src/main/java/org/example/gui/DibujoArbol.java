package org.example.gui;

import org.example.objetos.Arbol;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DibujoArbol {
    private static final int ESPACIO_HORIZONTAL = 20;
    private static final int ESPACIO_VERTICAL = 50;
    private static final int TAMANO_NODO = 50;
    private final Arbol<String> modelo;
    private HashMap<Rectangle, String> nodoCoordenadas;

    public DibujoArbol(Arbol<String> modelo) {
        this.modelo = modelo;
        this.nodoCoordenadas = new HashMap<>();
    }

    public void dibujar(Graphics g) {
        dibujarNodo(modelo.getRaiz(), 100, 100, g);
    }

    public void dibujarNodo(Arbol.Nodo<String> nodo, int x, int y, Graphics g) {

        int ancho = ancho(nodo);

        int xNodo = x +ancho/2 - (TAMANO_NODO/2);

        int xHijo = x;
        int yHijo = y + TAMANO_NODO + ESPACIO_VERTICAL;
        for(Arbol.Nodo<String> hijo : nodo.getHijos()) {
            int avanzar = ancho(hijo) + ESPACIO_HORIZONTAL;

            g.setColor(Color.black);
            g.drawLine(xNodo + TAMANO_NODO/2, y + TAMANO_NODO / 2,
                    xHijo + (avanzar-ESPACIO_HORIZONTAL)/2,
                    yHijo + TAMANO_NODO/2);

            dibujarNodo(hijo, xHijo, yHijo, g);
            xHijo += avanzar;
        }

        Rectangle nodoRect = new Rectangle(xNodo, y, TAMANO_NODO, TAMANO_NODO);
        nodoCoordenadas.put(nodoRect, nodo.getContenido());

        g.setColor(Color.white);
        g.fillOval(xNodo, y,
                TAMANO_NODO, TAMANO_NODO);
        g.setColor(Color.black);
        g.drawOval(xNodo, y,
                TAMANO_NODO, TAMANO_NODO);
        g.drawString(nodo.getContenido(),xNodo + 10, y+20);
    }

    public int ancho(Arbol.Nodo<String> nodo) {

        if (nodo.getHijos().tamano() == 0) {
            return TAMANO_NODO;
        }

        int ancho = 0;
        int espacio = 0;
        for(Arbol.Nodo<String> hijo : nodo.getHijos()) {
            int avanzar = espacio + ancho(hijo);
            ancho += avanzar;
            espacio = ESPACIO_HORIZONTAL;
        }
        return ancho;
    }

    public String obtenerNodoClic(int xClic, int yClic) {
        for (Map.Entry<Rectangle, String> entry : nodoCoordenadas.entrySet()) {
            Rectangle rect = entry.getKey();
            if (rect.contains(xClic, yClic)) {
                return entry.getValue();
            }
        }
        return null;
    }
}