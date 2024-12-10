package org.example;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        grafo = Ficheros.leerFichero("almonte5.tsp");
        System.out.println(BusquedaVorazExhausitvaUni.costeMinimo(grafo));

        Auxiliares.Menu();
    }
}