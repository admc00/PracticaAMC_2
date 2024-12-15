package org.example;

import java.util.*;

public class BusquedaVorazExhausitvaUni {

    private static final List<Ciudad> ruta = new ArrayList<>();
    private static double coste = 0;

    private static double tiempo = 0;

    public static double costeMinimo(Grafo grafo, Ciudad ciudadInicial) {
        long startTime = System.currentTimeMillis();
        ruta.clear();
        coste = 0;

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


        RutaPanel.mostrarRuta(ruta, "BusquedaVorazExhausitvaUni");

        long endTime = System.currentTimeMillis();
        tiempo = (endTime - startTime);

        return coste;

    }

    public static double getTiempo() {
        return tiempo;
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
}
