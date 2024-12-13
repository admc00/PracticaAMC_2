package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BusquedaVorazPodaBi {
    private static List<Ciudad> ruta = new ArrayList<>();
    private static double coste = 0;

    public static double costeMinimo(Grafo grafo, Ciudad ciudadInicial) {
        Set<Ciudad> ciudades = grafo.obtenerCiudades();
        //if (ciudades.isEmpty()) return Collections.emptyList();

        // Elegir una ciudad inicial aleatoriamente
        /*Ciudad ciudadInicial = ciudades.stream().filter(ciudad -> ciudad.getID() == 1).findFirst().get();/*ciudades
                .stream()
                .skip(new Random(System.currentTimeMillis()).nextInt(ciudades.size()))
                .findFirst().orElse(null);*/

        //int indiceCiudadInicial = ruta.indexOf(ciudadInicial);
        int idCiudadInicial = ciudadInicial.getID();

        // Inicializar variables
        ruta.add(ciudadInicial);
        ciudadInicial.setVisitada(true);

        // Para recorrer bidireccionalmente
        Ciudad extremoInicio = ciudadInicial;
        Ciudad extremoFin = ciudadInicial;

        // Repetir hasta visitar todas las ciudades
        while (ruta.size() < ciudades.size()) {
            // Buscar la ciudad más cercana a cada extremo
            Camino caminoMasCortoInicio = buscarCaminoMasCorto(grafo, extremoInicio);
            Camino caminoMasCortoFin = buscarCaminoMasCorto(grafo, extremoFin);

            // Comparar las distancias y elegir la ruta más corta
            if (caminoMasCortoInicio != null && caminoMasCortoFin != null) {
                if (caminoMasCortoInicio.getPeso() <= caminoMasCortoFin.getPeso()) {
                    extremoInicio = caminoMasCortoInicio.getC2();
                    ruta.addFirst(extremoInicio); // add(0, extremoInicio);
                    coste += caminoMasCortoInicio.getPeso();
                } else {
                    extremoFin = caminoMasCortoFin.getC2();
                    ruta.add(extremoFin);
                    coste += caminoMasCortoFin.getPeso();
                }
            } else if (caminoMasCortoInicio != null) {
                extremoInicio = caminoMasCortoInicio.getC2();
                ruta.addFirst(extremoInicio);
                coste += caminoMasCortoInicio.getPeso();
            } else if (caminoMasCortoFin != null) {
                extremoFin = caminoMasCortoFin.getC2();
                ruta.add(extremoFin);
                coste += caminoMasCortoFin.getPeso();
            }

            // Marcar la ciudad como visitada
            if (extremoInicio != null) extremoInicio.setVisitada(true);
            if (extremoFin != null) extremoFin.setVisitada(true);
        }

        var indiceCiudadInicial = ruta.indexOf(ciudades.stream().filter(ciudad -> ciudad.getID() == idCiudadInicial).findFirst().get());
        Collections.rotate(ruta, -indiceCiudadInicial); // No es -1 sino la distancia que hay desde el elemento de inicio hasta 0

        System.out.println(ruta.toString() + "\n"+ ruta.size() + "\n" + idCiudadInicial);

        RutaPanel.mostrarRuta(ruta, "BusquedaVorazPodaBi");
        return coste;
    }

    // Metodo para buscar la ciudad más cercana a un extremo
    private static Camino buscarCaminoMasCorto(Grafo grafo, Ciudad ciudadActual) {
        Set<Camino> caminos = grafo.obtenerCaminos(ciudadActual);
        Camino caminoMasCorto = null;
        double pesoMinimo = Double.MAX_VALUE;

        for (Camino camino : caminos) {
            Ciudad ciudadDes = camino.getC2().equals(ciudadActual) ? camino.getC1() : camino.getC2();

            if (!ciudadDes.esVisitada() && camino.getPeso() < pesoMinimo) {
                caminoMasCorto = camino;
                pesoMinimo = camino.getPeso();
            }

            if(Math.abs(ciudadActual.getX() - ciudadDes.getX()) >= pesoMinimo) {break;}


        }

        return caminoMasCorto;
    }
}
