package org.example;

import java.util.*;

public class Grafo {

    /// Mapa para almacenar las relaciones entre ciudades y sus caminos
    private Map<Ciudad, Set<Camino>> relaciones;

    // Constructor
    public Grafo() {
        this.relaciones = new LinkedHashMap<>();
    }

    public Grafo(Grafo g) {
        this.relaciones = new LinkedHashMap<>(g.relaciones);
    }

    /**
     * Agregar un ciudad al grafo.
     * Si la ciudad ya existe, no se realiza ninguna acción.
     *
     * @param ciudad El ciudad a agregar.
     */
    public void agregarCiudad(Ciudad ciudad) {
        relaciones.putIfAbsent(ciudad, new HashSet<>());
    }

    /**
     * Agregar un camino al grafo. Si alguno de las ciudades del camino no existe,
     * se agrega automáticamente.
     *
     * @param ciudad1 Ciudad de inicio del camino.
     * @param ciudad2 Ciudad final del camino.
     * @param camino  El camino a agregar.
     */
    public void agregarCamino(Ciudad ciudad1, Ciudad ciudad2, Camino camino) {
        // Agregar las ciudades si no existen
        agregarCiudad(ciudad1);
        agregarCiudad(ciudad2);

        // Asociar el camino con ambas ciudades
        relaciones.get(ciudad1).add(camino);
        //relaciones.get(ciudad2).add(camino);
    }

    /**
     * Obtener los caminos asociadas a una ciudad.
     *
     * @param ciudad La ciudad del que se quieren obtener los caminos.
     * @return Un conjunto de caminos asociados a la ciudad, o null si la ciudad no existe.
     */
    public Set<Camino> obtenerCaminos(Ciudad ciudad) {
        return relaciones.getOrDefault(ciudad, null);
    }

    /**
     * Verificar si el grafo contiene una ciudad.
     *
     * @param ciudad La ciudad a verificar.
     * @return true si la ciudad está en el grafo, false en caso contrario.
     */
    public boolean contieneCiudad(Ciudad ciudad) {
        return relaciones.containsKey(ciudad);
    }

    /**
     * Verificar si el grafo contiene un camino.
     *
     * @param camino El camino a verificar.
     * @return true si el camino está en el grafo, false en caso contrario.
     */
    public boolean contieneCamino(Camino camino) {
        return relaciones.values().stream()
                .anyMatch(caminos -> caminos.contains(camino));
    }

    /**
     * Obtener todas las ciudades del grafo.
     *
     * @return Un conjunto con todas las ciudades del grafo.
     */
    public Set<Ciudad> obtenerCiudades() {
        return relaciones.keySet();
    }

    /**
     * Poner el atributo visitada de las ciudades a false.
     *
     */
    public void resetearGrafo() {
        for (Ciudad ciudad : obtenerCiudades()) {
            ciudad.setVisitada(false);
        }
    }

    /**
     * Dejar el grafo vacio.
     *
     */
    public void borrarGrafo() {
        relaciones.clear();
    }

    /**
     *
     * Ordena las ciudades del grafo por su coordenada X.
     *
     */
    public void ordenarPorCoordenadaX() {
        List<Ciudad> ciudades = new ArrayList<>(relaciones.keySet());
        ciudades.sort(Comparator.comparingDouble(Ciudad::getX));
        Map<Ciudad, Set<Camino>> sortedRelaciones = new LinkedHashMap<>();
        for (Ciudad ciudad : ciudades) {
            sortedRelaciones.put(ciudad, relaciones.get(ciudad));
        }
        relaciones = sortedRelaciones;
    }

    @Override
    public String toString() {
        String grafo_string = "Grafo: {";

        for (Ciudad ciudad : obtenerCiudades()) {
            grafo_string = grafo_string.concat("\n\tCiudad: " + ciudad.toString() + " {");
            for (Camino camino : obtenerCaminos(ciudad)) {
                grafo_string = grafo_string.concat(camino.toString());
            }
            grafo_string = grafo_string.concat("}");
        }
        grafo_string = grafo_string.concat("}\n");
        return grafo_string;
    }
}

