package org.example;

import java.util.*;

public class BusquedaVorazExhausitvaUni {

    private static ArrayList<Ciudad> ruta = new ArrayList<>();
    private static double coste = 0;

    public static double costeMinimo(Grafo grafo, Ciudad ciudadInicial) {
        Set<Ciudad> ciudades = grafo.obtenerCiudades();
        /*if (ciudades.isEmpty()) {
            return 0;
        }*/

        // Elegir una ciudad aleatoria para comenzar
        Ciudad ciudadActual = ciudadInicial;
        ciudadActual.setVisitada(true);
        ruta.add(ciudadActual);

        while (ruta.size() < ciudades.size()) {
            Ciudad ciudadMasCercana = encontrarCiudadMasCercana(grafo, ciudadActual);
            if (ciudadMasCercana != null) {
                ruta.add(ciudadMasCercana);

                ciudadMasCercana.setVisitada(true);
                ciudadActual = ciudadMasCercana;

            } else {
                break;
            }

        }

        //coste = calcularCosteRuta(grafo, ruta);

        // Imprimir la ruta
        System.out.println("Ruta: " + ruta);
        System.out.println("\n");
        System.out.println("Número de ciudades visitadas: " + ruta.size());
        System.out.println("Coste: " + coste);



        RutaPanel.mostrarRuta(ruta, "BusquedaVorazExhausitvaUni");

        return coste;

    }

    private static Ciudad encontrarCiudadMasCercana(Grafo grafo, Ciudad ciudadActual) {
        Set<Camino> caminos = grafo.obtenerCaminos(ciudadActual);
        Ciudad ciudadMasCercana = null;
        double pesoMinimo = Double.MAX_VALUE;


        Ciudad ciudadVecina;
        for (Camino camino : caminos) {
            Ciudad C1 = camino.getC1();
            Ciudad C2 = camino.getC2();
            ciudadVecina = C1.equals(ciudadActual) ? C2 : C1;
            if (!ciudadVecina.esVisitada()) {
                if (camino.getPeso() < pesoMinimo) {
                    pesoMinimo = camino.getPeso();
                    ciudadMasCercana = ciudadVecina;
                }
            }

        }

        coste += pesoMinimo;

        return ciudadMasCercana;
    }

//    private static double calcularCosteRuta(Grafo grafo, List<Ciudad> ruta) {
//        double costeTotal = 0;
//        for (int i = 0; i < ruta.size() - 1; i++) {
//            Ciudad ciudadActual = ruta.get(i);
//            Ciudad ciudadSiguiente = ruta.get(i + 1);
//            Set<Camino> caminos = grafo.obtenerCaminos(ciudadActual);
//            for (Camino camino : caminos) {
//                if ((camino.getC1().equals(ciudadActual) && camino.getC2().equals(ciudadSiguiente)) ||
//                        (camino.getC1().equals(ciudadSiguiente) && camino.getC2().equals(ciudadActual))) {
//                    costeTotal += camino.getPeso();
//                    break;
//                }
//            }
//        }
//        return costeTotal;
//    }
}
