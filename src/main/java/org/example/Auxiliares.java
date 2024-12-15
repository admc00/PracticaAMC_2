package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Auxiliares {

    private static Grafo grafo;

    public static void Menu(){
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
            menu.setVisible(false);
            compararTodasLasEstrategias();
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
            menu.setVisible(false);
            compararUniBi();
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
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("berlin52.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch130 = new JButton("Ch130");
        ch130.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("ch130.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch150 = new JButton("Ch150");
        ch150.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("ch150.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d493 = new JButton("d493");
        d493.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("d493.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d657 = new JButton("d657");
        d657.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("d657.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton almonte5 = new JButton("almonte5");
        almonte5.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            if(grafo != null){
                grafo.borrarGrafo();
            }
            grafo = Ficheros.leerFichero("almonte5.tsp");
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
        almonte5.setBounds(50, 210, 200, 30);
        salir.setBounds(50, 250, 200, 30);

        nuevaVentana.add(berlin52);
        nuevaVentana.add(ch130);
        nuevaVentana.add(ch150);
        nuevaVentana.add(d493);
        nuevaVentana.add(d657);
        nuevaVentana.add(almonte5);
        nuevaVentana.add(salir);


        nuevaVentana.setVisible(true);

    }

    public static void ComprobarEstrategias() {
        JFrame ComprobarEstrategias = new JFrame("Comprobar Estrategias");
        ComprobarEstrategias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ComprobarEstrategias.setSize(450, 200);
        //ComprobarEstrategias.setLayout(null);
        ComprobarEstrategias.setLocationRelativeTo(null);

        // Declaracion ciudades iniciales generadas aleatoriamente
        Ciudad ciudadInicial, ciudadInicialOrdenada;

        // Reseteamos las ciudades del grafo desordenado en caso de que haya sido usado previamente.
        //grafo.resetearGrafo();

        /*
         Generamos una ciudad inicial de forma aleatoria, usando como semilla el reloj
         del sistema, (casi) garantizando asi un resultado diferente cada vez.
        */
        ciudadInicial = obtenerCiudadInicial(grafo);

        // Ordenamos el grafo almacenandolo en un nuevo grafo
        Grafo grafoOrd = new Grafo(grafo);
        grafoOrd.ordenarPorCoordenadaX();

        /*
         Obtenemos la ciudad con mismo ID que la anteriormente
         generada de forma aleatoria,
         del grafo ordenado, para asi no trabajar
         con la ciudad asociada al grafo desordenado,
         en el grafo ordenado.*/

        ciudadInicialOrdenada = grafoOrd.obtenerCiudades()
                .stream()
                .filter(ciudad -> ciudad.getID() == ciudadInicial.getID())
                .findFirst().orElse(null);


        double costeMinimoEXU = BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
        grafo.resetearGrafo();


        double costeMinimoPOU = BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicialOrdenada);
        grafoOrd.resetearGrafo();


        double costeMinimoEXB = BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
        grafo.resetearGrafo();



        double costeMinimoPOB = BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicialOrdenada);
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
                // Llamar al metodo que crea el archivo con el tamaño especificado
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

    public static void compararTodasLasEstrategias() {
        JFrame CompararTodasLasEstrategias = new JFrame("Comparar Todas Las Estrategias");
        CompararTodasLasEstrategias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CompararTodasLasEstrategias.setSize(600, 400);
        CompararTodasLasEstrategias.setLocationRelativeTo(null);

        String[] columnNames = {"Tamaño", "Estrategia", "Tiempo Medio (ms)"};
        List<Object[]> data = new ArrayList<>();

        Ciudad ciudadInicial;

        int[] tamanos = {50, 100, 200}; //
        int numExperimentos = 10;



        for (int tamano : tamanos) {
            Double tiempoExhaustivoUni = 0.0;
            Double tiempoPodaUni = 0.0;
            Double tiempoExhaustivoBi = 0.0;
            Double tiempoPodaBi = 0.0;

            for (int i = 0; i < numExperimentos; i++) {
                Ficheros.crearArchivoTSP(tamano);
                grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                ciudadInicial = obtenerCiudadInicial(grafo);
                Grafo grafoOrd = new Grafo(grafo);
                grafoOrd.ordenarPorCoordenadaX();

                BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
                tiempoExhaustivoUni += BusquedaVorazExhausitvaUni.getTiempo();
                grafo.resetearGrafo();

                BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicial);
                tiempoPodaUni += BusquedaVorazPodaUni.getTiempo();
                grafoOrd.resetearGrafo();

                BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
                tiempoExhaustivoBi += BusquedaVorazExhaustivaBi.getTiempo();
                grafo.resetearGrafo();

                BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicial);
                tiempoPodaBi += BusquedaVorazPodaBi.getTiempo();
                grafoOrd.resetearGrafo();
            }
            data.add(new Object[]{tamano, "Unidireccional Exhaustivo", tiempoExhaustivoUni / numExperimentos});
            data.add(new Object[]{tamano, "Unidireccional con Poda", tiempoPodaUni / numExperimentos});
            data.add(new Object[]{tamano, "Bidireccional Exhaustivo", tiempoExhaustivoBi / numExperimentos});
            data.add(new Object[]{tamano, "Bidireccional con Poda", tiempoPodaBi / numExperimentos});
        }

        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> {
            CompararTodasLasEstrategias.setVisible(false);
            Menu();
        });

        CompararTodasLasEstrategias.add(salir, BorderLayout.SOUTH);
        CompararTodasLasEstrategias.add(scrollPane, BorderLayout.CENTER);
        CompararTodasLasEstrategias.setVisible(true);
    }

    public static void comparar2Estrategias(){


    }

    private static void compararUniBi() {
        JFrame CompararUniBi = new JFrame("Comparar Unidireccional vs Bidireccional");
        CompararUniBi.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        CompararUniBi.setSize(600, 400);
        CompararUniBi.setLocationRelativeTo(null);

        String[] columnNames = {"Tamaño", "Vencedor", "Tiempo Medio (ms)", "Nº victorias"};
        List<Object[]> data = new ArrayList<>();

        Ciudad ciudadInicial;

        int[] tamanos = {50, 100, 200}; //
        int numExperimentos = 10;

        for (int tamano : tamanos) {
            Double tiempoExhaustivoUni = 0.0;
            Double tiempoPodaUni = 0.0;
            Double tiempoExhaustivoBi = 0.0;
            Double tiempoPodaBi = 0.0;

            int victoriasUNI = 0, victoriasBI = 0;

            for (int i = 0; i < numExperimentos; i++) {
                Ficheros.crearArchivoTSP(tamano);
                grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                ciudadInicial = obtenerCiudadInicial(grafo);
                Grafo grafoOrd = new Grafo(grafo);
                grafoOrd.ordenarPorCoordenadaX();

                double costeEXU = BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
                tiempoExhaustivoUni += BusquedaVorazExhausitvaUni.getTiempo();
                grafo.resetearGrafo();

                double costePOU = BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicial);
                tiempoPodaUni += BusquedaVorazPodaUni.getTiempo();
                grafoOrd.resetearGrafo();

                double costeEXB = BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
                tiempoExhaustivoBi += BusquedaVorazExhaustivaBi.getTiempo();
                grafo.resetearGrafo();

                double costePOB = BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicial);
                tiempoPodaBi += BusquedaVorazPodaBi.getTiempo();
                grafoOrd.resetearGrafo();

                if (costeEXU != costeEXB) {
                    if (costeEXU > costeEXB) {
                        victoriasUNI++;
                    }else {
                        victoriasBI++;
                    }
                }

                if (costePOU != costePOB) {
                    if (costePOU > costePOB) {
                        victoriasUNI++;
                    }else {
                        victoriasBI++;
                    }
                }
            }

            String vencedor = victoriasUNI == victoriasBI ?
                    "Empate" :
                    victoriasUNI > victoriasBI ?
                            "Unidireccional" :
                            "Bidireccional";
            Double tiempoVencedor = vencedor == "Unidireccional" ? tiempoExhaustivoUni + tiempoPodaUni : tiempoExhaustivoBi + tiempoPodaBi;

            data.add(new Object[]{tamano, vencedor, tiempoVencedor / numExperimentos, vencedor == "Unidireccional" ? victoriasUNI : victoriasBI});
        }

        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> {
            CompararUniBi.setVisible(false);
            Menu();
        });

        CompararUniBi.add(salir, BorderLayout.SOUTH);
        CompararUniBi.add(scrollPane, BorderLayout.CENTER);
        CompararUniBi.setVisible(true);
    }

    private static Ciudad obtenerCiudadInicial(Grafo grafo) {
        var ciudades = grafo.obtenerCiudades();
        return ciudades.stream()
                .skip(new Random(System.currentTimeMillis()).nextInt(ciudades.size()))
                .findFirst().orElse(null);
    }

}
