//package org.example.archivos;
//
//import org.example.objetos.Arbol;
//
//import java.io.File;
//
//public class TestLectorArbol {
//    public static void main(String[] args) throws Exception {
//        File archivo = new File("D:\\Users new\\Escritorio\\arbol.txt");
//        if (!archivo.exists() || !archivo.canRead()) {
//            System.out.println("No existe o no podemos leer");
//            System.exit(0);
//        }
//        LectorArbol lector = new LectorArbol(archivo);
//        Arbol<String> arbol = lector.leer();
//
//        arbol.existe("Hugo");
//
//        System.out.println(arbol);
//    }
//
//}
