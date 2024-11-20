package org.example;

import java.util.*;

public class Grafo {

    /// Mapa para almacenar las relaciones entre puntos y sus aristas
    public Map<Punto, Set<Arista>> relaciones;

    // Constructor
    public Grafo() {
        this.relaciones = new LinkedHashMap<>();
    }

    /**
     * Agregar un punto al grafo.
     * Si el punto ya existe, no se realiza ninguna acción.
     *
     * @param punto El punto a agregar.
     */
    public void agregarPunto(Punto punto) {
        relaciones.putIfAbsent(punto, new HashSet<>());
    }

    /**
     * Agregar una arista al grafo. Si alguno de los puntos de la arista no existe,
     * se agrega automáticamente.
     *
     * @param punto1 Punto de inicio de la arista.
     * @param punto2 Punto final de la arista.
     * @param arista La arista a agregar.
     */
    public void agregarArista(Punto punto1, Punto punto2, Arista arista) {
        // Agregar los puntos si no existen
        agregarPunto(punto1);
        agregarPunto(punto2);

        // Asociar la arista con ambos puntos
        relaciones.get(punto1).add(arista);
        relaciones.get(punto2).add(arista);
    }

    /**
     * Obtener las aristas asociadas a un punto.
     *
     * @param punto El punto del que se quieren obtener las aristas.
     * @return Un conjunto de aristas asociadas al punto, o null si el punto no existe.
     */
    public Set<Arista> obtenerAristas(Punto punto) {
        return relaciones.getOrDefault(punto, null);
    }

    /**
     * Verificar si el grafo contiene un punto.
     *
     * @param punto El punto a verificar.
     * @return true si el punto está en el grafo, false en caso contrario.
     */
    public boolean contienePunto(Punto punto) {
        return relaciones.containsKey(punto);
    }

    /**
     * Verificar si el grafo contiene una arista.
     *
     * @param arista La arista a verificar.
     * @return true si la arista está en el grafo, false en caso contrario.
     */
    public boolean contieneArista(Arista arista) {
        return relaciones.values().stream()
                .anyMatch(aristas -> aristas.contains(arista));
    }

    /**
     * Obtener todos los puntos del grafo.
     *
     * @return Un conjunto con todos los puntos del grafo.
     */
    public Set<Punto> obtenerPuntos() {
        return relaciones.keySet();
    }

    @Override
    public String toString() {
        String grafo_string = "Grafo: {\n\n";

        for (Punto punto : obtenerPuntos()) {
            grafo_string = grafo_string.concat("Punto: " + punto.toString() + " {");
            for (Arista arista : obtenerAristas(punto)) {
                grafo_string = grafo_string.concat(arista.toString());
            }
            grafo_string.concat("}\n\n");
        }

        return grafo_string;
    }
}

