package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class BusquedaVorazPodaBi {

    private static final List<Ciudad> ruta = new ArrayList<>();
    private static double coste = 0;

    private static double tiempo = 0;

    private static double calculadas = 0;

    /**
     * Calcula el coste mínimo de un recorrido por todas las ciudades del grafo.
     *
     * @return Coste mínimo del recorrido.
     */

    public static double costeMinimo(Grafo grafo, Ciudad ciudadInicial) {
        long startTime = System.currentTimeMillis();
        ruta.clear();
        coste = 0;
        calculadas = 0;

        Set<Ciudad> ciudades = grafo.obtenerCiudades();

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


        //RutaPanel.mostrarRuta(ruta, "BusquedaVorazPodaBi");

        long endTime = System.currentTimeMillis();
        tiempo = (endTime - startTime);
        return coste;
    }


    /**
     * Obtiene el tiempo de ejecución de la última llamada a costeMinimo.
     *
     * @return Tiempo de ejecución en milisegundos.
     */
    public static double getTiempo() {
        return tiempo;
    }


    /**
     * Obtiene el número de distancias euclideas calculadas en la última llamada a costeMinimo.
     *
     * @return Número de distancias euclideas calculadas.
     */
    public static double getCalculadas() {
        return calculadas;
    }

    /**
     * Busca el camino más corto desde la ciudad actual.
     *
     * @param grafo Grafo de ciudades.
     * @param ciudadActual Ciudad actual.
     * @return Camino más corto.
     */
    private static Camino buscarCaminoMasCorto(Grafo grafo, Ciudad ciudadActual) {
        Set<Camino> caminos = grafo.obtenerCaminos(ciudadActual);
        Camino caminoMasCorto = null;
        double pesoMinimo = Double.MAX_VALUE;

        for (Camino camino : caminos) {
            Ciudad ciudadDestino = camino.getC2().equals(ciudadActual) ? camino.getC1() : camino.getC2();
            if ((ciudadDestino.getX() - ciudadActual.getX()) <= pesoMinimo) {
                calculadas++;
                if (!ciudadDestino.esVisitada() && (caminoMasCorto == null || camino.getPeso() < caminoMasCorto.getPeso())) {
                    caminoMasCorto = camino;
                    pesoMinimo = camino.getPeso();
                }
            }
        }
        return caminoMasCorto;
    }
}
