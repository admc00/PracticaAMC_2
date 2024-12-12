package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Auxiliares {

    private static Grafo grafo, grafoOrd;

    public static void Menu() {
        JFrame menu = new JFrame("Menú");
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(400, 300);
        menu.setLayout(null);
        menu.setLocationRelativeTo(null);

        // Crear Botones de Menú
        JButton CrearArchivo = new JButton("Crear Archivo");
        CrearArchivo.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Crear Archivo");
            CrearArchivo();
        });

        JButton CargarArchivo = new JButton("Cargar Archivo");
        CargarArchivo.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Cargar Archivo");
            CargarArchivo();
            menu.setVisible(false);
        });
        JButton ComprobarEstrategias = new JButton("Comprobar Estrategias");
        ComprobarEstrategias.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Comprobar Estrategias");
            menu.setVisible(false);
            ComprobarEstrategias();

        });
        JButton CompararEstrategias = new JButton("Comparar Todas Las Estrategias");
        CompararEstrategias.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Comparar Todas Las Estrategias");
        });
        JButton Comparar2Estrategias = new JButton("Comparar 2 Estrategias");
        Comparar2Estrategias.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Comparar 2 Estrategias");
        });
        JButton CompararUniBi = new JButton("Unidireccional vs Bidireccional");
        CompararUniBi.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            System.out.println("Unidireccional vs Bidireccional");
        });


        CrearArchivo.setBounds(50, 10, 300, 30);
        CargarArchivo.setBounds(50, 50, 300, 30);
        ComprobarEstrategias.setBounds(50, 90, 300, 30);
        CompararEstrategias.setBounds(50, 130, 300, 30);
        Comparar2Estrategias.setBounds(50, 170, 300, 30);
        CompararUniBi.setBounds(50, 210, 300, 30);



        menu.add(CrearArchivo);
        menu.add(CargarArchivo);
        menu.add(ComprobarEstrategias);
        menu.add(CompararEstrategias);
        menu.add(Comparar2Estrategias);
        menu.add(CompararUniBi);

        menu.setVisible(true);
    }

    public static void CargarArchivo(){
        JFrame nuevaVentana = new JFrame("Cargar Archivo");
        nuevaVentana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevaVentana.setSize(310, 300);
        nuevaVentana.setLayout(null);
        nuevaVentana.setLocationRelativeTo(null);


        JButton berlin52 = new JButton("Berlin52");
        berlin52.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            grafo = Ficheros.leerFichero("berlin52.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch130 = new JButton("Ch130");
        ch130.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("ch130.tsp");
            grafo = Ficheros.leerFichero("ch130.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch150 = new JButton("Ch150");
        ch150.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("ch150.tsp");
            grafo = Ficheros.leerFichero("ch150.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d493 = new JButton("d493");
        d493.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("d493.tsp");
            grafo = Ficheros.leerFichero("d493.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d657 = new JButton("d657");
        d657.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("d657.tsp");
            grafo = Ficheros.leerFichero("d657.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            nuevaVentana.setVisible(false);
            Menu();
        });


        berlin52.setBounds(50, 10, 200, 30);
        ch130.setBounds(50, 50, 200, 30);
        ch150.setBounds(50, 90, 200, 30);
        d493.setBounds(50, 130, 200, 30);
        d657.setBounds(50, 170, 200, 30);
        salir.setBounds(50, 210, 200, 30);

        nuevaVentana.add(berlin52);
        nuevaVentana.add(ch130);
        nuevaVentana.add(ch150);
        nuevaVentana.add(d493);
        nuevaVentana.add(d657);
        nuevaVentana.add(salir);


        nuevaVentana.setVisible(true);

    }

    public static void ComprobarEstrategias() {
        JFrame ComprobarEstrategias = new JFrame("Comprobar Estrategias");
        ComprobarEstrategias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ComprobarEstrategias.setSize(450, 200);
        //ComprobarEstrategias.setLayout(null);
        ComprobarEstrategias.setLocationRelativeTo(null);

        grafoOrd = ordenarGrafo(grafo);

        double costeMinimoEXB = BusquedaVorazExhaustivaBi.costeMinimo(grafo);
        grafo.resetearGrafo();
        double costeMinimoEXU = BusquedaVorazExhausitvaUni.costeMinimo(grafo);
        grafo.resetearGrafo();
        double costeMinimoPOU = BusquedaVorazPodaUni.costeMinimo(grafoOrd);
        grafoOrd.resetearGrafo();
        double costeMinimoPOB = BusquedaVorazPodaBi.costeMinimo(grafoOrd);
        grafoOrd.resetearGrafo();

        String[] columnNames = {"Estrategia", "Solución", "Calculadas", "Tiempo (mseg)"};
        Object[][] data = {
                    {"Unidireccional exhaustivo",costeMinimoEXU, 8386, 0.1679},
                    {"Bidireccional exhaustivo",costeMinimoEXB, 12249, 0.2317},
                    {"Unidireccional con poda",costeMinimoPOU, 2386, 0.1479},
                    {"Bidireccional con poda",costeMinimoPOB, 2947, 0.1571}
        };

        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            ComprobarEstrategias.setVisible(false);
            Menu();
        });

        ComprobarEstrategias.add(salir, BorderLayout.SOUTH);

        // Agregar la tabla al frame
        ComprobarEstrategias.add(scrollPane, BorderLayout.CENTER);

        ComprobarEstrategias.setVisible(true);

    }

    public static void CrearArchivo() {
        JFrame CrearArchivo = new JFrame("Crear Archivo");
        CrearArchivo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CrearArchivo.setSize(310, 300);
        CrearArchivo.setLayout(null);
        CrearArchivo.setLocationRelativeTo(null);

        String input = JOptionPane.showInputDialog(CrearArchivo, "Ingrese el tamaño del dataset:", "Entrada de Datos", JOptionPane.QUESTION_MESSAGE);
        if (input != null && !input.isEmpty()) {
            try {
                int size = Integer.parseInt(input);
                // Llamar al método que crea el archivo con el tamaño especificado
                Ficheros.crearArchivoTSP(size);
                JOptionPane.showMessageDialog(CrearArchivo, "Archivo creado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                grafo = Ficheros.leerFichero("dataset" + size + ".tsp");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(CrearArchivo, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(CrearArchivo, "No se ingresó ningún dato.", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * @param g Grafo a ordenar.
     * @return un grafo ordenado.
     */
    private static Grafo ordenarGrafo(Grafo g) {
        Grafo gOrdenado = new Grafo();
        var ciudades = g.obtenerCiudades();
        ArrayList<Ciudad> ciudadesOrdenadas = Ordenar.quickSort(new ArrayList<>(ciudades),0,ciudades.size()-1);

        for (Ciudad ciudad : ciudadesOrdenadas) {
            gOrdenado.agregarTupla(ciudad, g.obtenerCaminos(ciudad));
        }
        return gOrdenado;
    }

    private static class Ordenar {

        private Ordenar() {}

        public static ArrayList<Ciudad> quickSort(ArrayList<Ciudad> ciudades, int low, int high) {

            if (low < high) {
                int pi = partition(ciudades, low, high);

                quickSort(ciudades, low, pi - 1);
                quickSort(ciudades, pi + 1, high);
            }
            return ciudades;
        }

        private static int partition(ArrayList<Ciudad> ciudades, int low, int high) {
            Ciudad pivot = ciudades.get(high);
            int i = low - 1;

            for (int j = low; j < high; j++) {
                if (compare(ciudades.get(j), pivot) <= 0) {
                    i++;
                    swap(ciudades, i, j);
                }
            }

            swap(ciudades, i + 1, high);
            return i + 1;
        }

        private static double compare(Ciudad c1, Ciudad c2) {
            // Comparar los puntos según algún criterio, por ejemplo, comparar las coordenadas x o y.
            // Devolver un número negativo si c1 es menor que c2,
            // devolver 0 si c1 es igual a c2,
            // devolver un número positivo si c1 es mayor que c2.

            // Ejemplo de comparación por coordenada x:
            return Double.compare(c1.getX(), c2.getX());
        }

        private static void swap(ArrayList<Ciudad> ciudades, int i, int j) {
            Ciudad temp = ciudades.get(i);
            ciudades.set(i, ciudades.get(j));
            ciudades.set(j, temp);
        }
    }

}
