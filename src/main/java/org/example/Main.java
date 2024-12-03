package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Ficheros fichero = new Ficheros();
        Grafo grafo = fichero.leerFichero("almonte5.tsp");
        //System.out.println(grafo.toString());
        System.out.println(BusquedaVorazExhaustivaBi.costeMinimo(grafo));
    }
}
