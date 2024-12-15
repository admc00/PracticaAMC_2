package org.example;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Auxiliares.Menu();

        /*Grafo g = Ficheros.leerFichero("almonte5.tsp");
        Grafo g2 = new Grafo(g);
        //System.out.println(g.obtenerCiudades().size());

        g2.ordenarPorCoordenadaX();
        System.out.println(g);
        System.out.println(g2);

        Ciudad ciudadInicial, ciudadInicialOrdenada;

        ciudadInicial = g.obtenerCiudades()
                .stream()
                .filter(ciudad -> ciudad.getID() == 1)
                .findFirst().orElse(null);

        ciudadInicialOrdenada = g2.obtenerCiudades()
                .stream()
                .filter(ciudad -> ciudad.getID() == ciudadInicial.getID())
                .findFirst().orElse(null);



        g.resetearGrafo();
        g2.resetearGrafo();
        double costeMinimoEXU = BusquedaVorazExhausitvaUni.costeMinimo(g, ciudadInicial);
        var rutaEXU = BusquedaVorazExhausitvaUni.ruta;

        System.out.println(g);
        System.out.println(g2);
        g.resetearGrafo();
        g2.resetearGrafo();
        double costeMinimoPOU = BusquedaVorazPodaUni.costeMinimo(g2, ciudadInicialOrdenada);
        var rutaPOU = BusquedaVorazPodaUni.ruta;

        System.out.println(g);
        System.out.println(g2);
        g.resetearGrafo();
        g2.resetearGrafo();
        double costeMinimoEXB = BusquedaVorazExhaustivaBi.costeMinimo(g, ciudadInicial);
        var rutaEXB = BusquedaVorazExhaustivaBi.ruta;

        System.out.println(g);
        System.out.println(g2);
        g.resetearGrafo();
        g2.resetearGrafo();
        double costeMinimoPOB = BusquedaVorazPodaBi.costeMinimo(g2, ciudadInicialOrdenada);
        var rutaPOB = BusquedaVorazPodaBi.ruta;

        metod("EXU",rutaEXU,costeMinimoEXU);
        metod("POU",rutaPOU,costeMinimoPOU);
        metod("EXB",rutaEXB,costeMinimoEXB);
        metod("POB",rutaPOB,costeMinimoPOB);
        /*g = Ficheros.leerFichero("berlin52.tsp");
        g2 = new Grafo(g);
        System.out.println(g.obtenerCiudades().size());

        g2.ordenarPorCoordenadaX();
        System.out.println(g2);
        System.out.println(g);*/

    }

    private static void metod(String algoritmoNombre, List<Ciudad> ruta, double coste){
        System.out.println("Algoritmo: " + algoritmoNombre);
        System.out.println("Ruta: " + ruta);
        System.out.println("Coste: " + coste);
        System.out.println();
    }
}
