package org.example;

import java.util.*;

public class BusquedaVorazExhausitvaUni {

    private static ArrayList<Ciudad> ruta = new ArrayList<>();
    private static double coste = 0;

    public static double costeMinimo(Grafo grafo) {
        List<Ciudad> ciudades = new ArrayList<>(grafo.obtenerCiudades());
        if (ciudades.isEmpty()) {
            return 0;
        }

        // Elegir una ciudad aleatoria para comenzar
        Ciudad ciudadActual = ciudades.get(new Random().nextInt(ciudades.size()));
        ruta.add(ciudadActual);

        while (ruta.size() < grafo.obtenerCiudades().size()) {
            Ciudad ciudadMasCercana = encontrarCiudadMasCercana(grafo, ciudadActual);
            if (ciudadMasCercana != null) {
                ruta.add(ciudadMasCercana);

                ciudadMasCercana.setVisitada(true);
                ciudadActual = ciudadMasCercana;

            } else {
                break;
            }


        }

        // Imprimir la ruta
        System.out.println("Ruta: " + ruta);
        System.out.println("\n");
        System.out.println("Número de ciudades visitadas: " + ruta.size());

        return coste;
    }

    private static Ciudad encontrarCiudadMasCercana(Grafo grafo, Ciudad ciudadActual) {
        Set<Camino> caminos = grafo.obtenerCaminos(ciudadActual);
        Ciudad ciudadMasCercana = null;
        double pesoMinimo = Double.MAX_VALUE;


        Ciudad ciudadVecina = null;
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
