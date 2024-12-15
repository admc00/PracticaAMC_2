package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Auxiliares {

    private static Grafo grafo;
    private static int eleccionAlgoritmo;

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
            menu.setVisible(false);
            ElegirAlgoritmo();
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
        double tiempoEXU = BusquedaVorazExhausitvaUni.getTiempo();
        double calculadasEXU = BusquedaVorazExhausitvaUni.getCalculadas();
        grafo.resetearGrafo();


        double costeMinimoPOU = BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicialOrdenada);
        double tiempoPOU = BusquedaVorazPodaUni.getTiempo();
        double calculadasPOU = BusquedaVorazPodaUni.getCalculadas();
        grafoOrd.resetearGrafo();


        double costeMinimoEXB = BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
        double tiempoEXB = BusquedaVorazExhaustivaBi.getTiempo();
        double calculadasEXB = BusquedaVorazExhaustivaBi.getCalculadas();
        grafo.resetearGrafo();



        double costeMinimoPOB = BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicialOrdenada);
        double tiempoPOB = BusquedaVorazPodaBi.getTiempo();
        double calculadasPOB = BusquedaVorazPodaBi.getCalculadas();
        grafoOrd.resetearGrafo();




        String[] columnNames = {"Estrategia", "Solución", "Calculadas", "Tiempo (mseg)"};
        Object[][] data = {
                    {"Unidireccional exhaustivo",costeMinimoEXU,calculadasEXU ,tiempoEXU },
                    {"Bidireccional exhaustivo",costeMinimoEXB,calculadasEXB ,tiempoEXB },
                    {"Unidireccional con poda",costeMinimoPOU,calculadasPOU ,tiempoPOU },
                    {"Bidireccional con poda",costeMinimoPOB,calculadasPOB ,tiempoPOB }
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

    public static void comparar2Estrategias(int eleccionAlgoritmo) {
        JFrame Comparar2Estrategias = new JFrame("Comparar 2 Estrategias");
        Comparar2Estrategias.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Comparar2Estrategias.setSize(600, 400);
        Comparar2Estrategias.setLocationRelativeTo(null);

        String[] columnNames = {"Tamaño", "Estrategia", "Tiempo Medio (ms)", "Distancia Media"};
        List<Object[]> data = new ArrayList<>();

        Ciudad ciudadInicial;

        int[] tamanos = {50, 100, 200}; // Example dataset sizes
        int numExperimentos = 10;


        switch (eleccionAlgoritmo){
            case 1:{
                for (int tamano : tamanos) {
                    double tiempoExhaustivoUni = 0.0;
                    double distanciaExhaustivoUni = 0.0;
                    double tiempoPodaUni = 0.0;
                    double distanciaPodaUni = 0.0;

                    for (int i = 0; i < numExperimentos; i++) {
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);
                        Grafo grafoOrd = new Grafo(grafo);
                        grafoOrd.ordenarPorCoordenadaX();

                        BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoUni += BusquedaVorazExhausitvaUni.getCalculadas();
                        tiempoExhaustivoUni += BusquedaVorazExhausitvaUni.getTiempo();
                        grafo.resetearGrafo();

                        BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaUni += BusquedaVorazPodaUni.getCalculadas();
                        tiempoPodaUni += BusquedaVorazPodaUni.getTiempo();
                        grafoOrd.resetearGrafo();
                    }
                    data.add(new Object[]{tamano, "Unidireccional Exhaustivo", tiempoExhaustivoUni / numExperimentos, distanciaExhaustivoUni / numExperimentos});
                    data.add(new Object[]{tamano, "Unidireccional con Poda", tiempoPodaUni / numExperimentos, distanciaPodaUni / numExperimentos});
                }
                break;
            }

            case 2: {
                for (int tamano : tamanos) {
                    double tiempoExhaustivoUni = 0.0;
                    double distanciaExhaustivoUni = 0.0;
                    double tiempoExhaustivoBi = 0.0;
                    double distanciaExhaustivoBi = 0.0;

                    for (int i = 0; i < numExperimentos; i++) {
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);

                        BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoUni += BusquedaVorazExhausitvaUni.getCalculadas();
                        tiempoExhaustivoUni += BusquedaVorazExhausitvaUni.getTiempo();
                        grafo.resetearGrafo();

                        BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoBi += BusquedaVorazExhaustivaBi.getCalculadas();
                        tiempoExhaustivoBi += BusquedaVorazExhaustivaBi.getTiempo();
                        grafo.resetearGrafo();

                    }
                    data.add(new Object[]{tamano, "Unidireccional Exhaustivo", tiempoExhaustivoUni / numExperimentos, distanciaExhaustivoUni / numExperimentos});
                    data.add(new Object[]{tamano, "Bidireccional Exhaustivo", tiempoExhaustivoBi / numExperimentos, distanciaExhaustivoBi / numExperimentos});
                }
                break;
            }

            case 3:{
                for(int tamano : tamanos){
                    double tiempoExhaustivoUni = 0.0;
                    double distanciaExhaustivoUni = 0.0;
                    double tiempoPodaBi = 0.0;
                    double distanciaPodaBi = 0.0;

                    for(int i = 0; i < numExperimentos; i++){
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);
                        Grafo grafoOrd = new Grafo(grafo);
                        grafoOrd.ordenarPorCoordenadaX();

                        BusquedaVorazExhausitvaUni.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoUni += BusquedaVorazExhausitvaUni.getCalculadas();
                        tiempoExhaustivoUni += BusquedaVorazExhausitvaUni.getTiempo();
                        grafo.resetearGrafo();

                        BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaBi += BusquedaVorazPodaBi.getCalculadas();
                        tiempoPodaBi += BusquedaVorazPodaBi.getTiempo();
                        grafoOrd.resetearGrafo();
                    }
                    data.add(new Object[]{tamano, "Unidireccional Exhaustivo", tiempoExhaustivoUni / numExperimentos, distanciaExhaustivoUni / numExperimentos});
                    data.add(new Object[]{tamano, "Bidireccional con Poda", tiempoPodaBi / numExperimentos, distanciaPodaBi / numExperimentos});
                }
                break;
            }

            case 4:{
                for(int tamano : tamanos) {
                    double tiempoPodaUni = 0.0;
                    double distanciaPodaUni = 0.0;
                    double tiempoExhaustivoBi = 0.0;
                    double distanciaExhaustivoBi = 0.0;

                    for (int i = 0; i < numExperimentos; i++) {
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);
                        Grafo grafoOrd = new Grafo(grafo);
                        grafoOrd.ordenarPorCoordenadaX();

                        BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaUni += BusquedaVorazPodaUni.getCalculadas();
                        tiempoPodaUni += BusquedaVorazPodaUni.getTiempo();
                        grafoOrd.resetearGrafo();

                        BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoBi += BusquedaVorazExhaustivaBi.getCalculadas();
                        tiempoExhaustivoBi += BusquedaVorazExhaustivaBi.getTiempo();
                        grafo.resetearGrafo();

                    }
                    data.add(new Object[]{tamano, "Unidireccional con Poda", tiempoPodaUni / numExperimentos, distanciaPodaUni / numExperimentos});
                    data.add(new Object[]{tamano, "Bidireccional Exhaustivo", tiempoExhaustivoBi / numExperimentos, distanciaExhaustivoBi / numExperimentos});
                }
                break;
            }

            case 5: {
                for (int tamano : tamanos) {
                    double tiempoPodaUni = 0.0;
                    double distanciaPodaUni = 0.0;
                    double tiempoPodaBi = 0.0;
                    double distanciaPodaBi = 0.0;

                    for (int i = 0; i < numExperimentos; i++) {
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);
                        Grafo grafoOrd = new Grafo(grafo);
                        grafoOrd.ordenarPorCoordenadaX();

                        BusquedaVorazPodaUni.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaUni += BusquedaVorazPodaUni.getCalculadas();
                        tiempoPodaUni += BusquedaVorazPodaUni.getTiempo();
                        grafoOrd.resetearGrafo();

                        BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaBi += BusquedaVorazPodaBi.getCalculadas();
                        tiempoPodaBi += BusquedaVorazPodaBi.getTiempo();
                        grafoOrd.resetearGrafo();

                    }
                    data.add(new Object[]{tamano, "Unidireccional con Poda", tiempoPodaUni / numExperimentos, distanciaPodaUni / numExperimentos});
                    data.add(new Object[]{tamano, "Bidireccional con Poda", tiempoPodaBi / numExperimentos, distanciaPodaBi / numExperimentos});
                }
                break;
            }

            case 6: {
                for (int tamano : tamanos) {
                    double tiempoExhaustivoBi = 0.0;
                    double distanciaExhaustivoBi = 0.0;
                    double tiempoPodaBi = 0.0;
                    double distanciaPodaBi = 0.0;

                    for (int i = 0; i < numExperimentos; i++) {
                        Ficheros.crearArchivoTSP(tamano);
                        grafo = Ficheros.leerFichero("dataset" + tamano + ".tsp");
                        ciudadInicial = obtenerCiudadInicial(grafo);
                        Grafo grafoOrd = new Grafo(grafo);
                        grafoOrd.ordenarPorCoordenadaX();

                        BusquedaVorazExhaustivaBi.costeMinimo(grafo, ciudadInicial);
                        distanciaExhaustivoBi += BusquedaVorazExhaustivaBi.getCalculadas();
                        tiempoExhaustivoBi += BusquedaVorazExhaustivaBi.getTiempo();
                        grafo.resetearGrafo();

                        BusquedaVorazPodaBi.costeMinimo(grafoOrd, ciudadInicial);
                        distanciaPodaBi += BusquedaVorazPodaBi.getCalculadas();
                        tiempoPodaBi += BusquedaVorazPodaBi.getTiempo();
                        grafoOrd.resetearGrafo();

                    }
                    data.add(new Object[]{tamano, "Bidireccional Exhaustivo", tiempoExhaustivoBi / numExperimentos, distanciaExhaustivoBi / numExperimentos});
                    data.add(new Object[]{tamano, "Bidireccional con Poda", tiempoPodaBi / numExperimentos, distanciaPodaBi / numExperimentos});
                }
            }
        }

        JTable table = new JTable(data.toArray(new Object[0][]), columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        JButton salir = new JButton("Salir");
        salir.addActionListener(e -> {
            Comparar2Estrategias.setVisible(false);
            Menu();
        });

        Comparar2Estrategias.add(salir, BorderLayout.SOUTH);
        Comparar2Estrategias.add(scrollPane, BorderLayout.CENTER);
        Comparar2Estrategias.setVisible(true);
    }

    private static void ElegirAlgoritmo(){
        JFrame ElegirAlgoritmo = new JFrame("Elegir Algoritmo");
        ElegirAlgoritmo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ElegirAlgoritmo.setSize(400, 300);
        ElegirAlgoritmo.setLocationRelativeTo(null);
        ElegirAlgoritmo.setLayout(new GridLayout(0, 1));

        JCheckBox alg1 = new JCheckBox("Unidireccional Exhaustivo");
        JCheckBox alg2 = new JCheckBox("Unidireccional con Poda");
        JCheckBox alg3 = new JCheckBox("Bidireccional Exhaustivo");
        JCheckBox alg4 = new JCheckBox("Bidireccional con Poda");

        JButton confirmar = new JButton("Confirmar");


        ElegirAlgoritmo.add(alg1);
        ElegirAlgoritmo.add(alg2);
        ElegirAlgoritmo.add(alg3);
        ElegirAlgoritmo.add(alg4);
        ElegirAlgoritmo.add(confirmar);

        ElegirAlgoritmo.setVisible(true);

        confirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int seleccion = 0;
                if (alg1.isSelected()) seleccion++;
                if (alg2.isSelected()) seleccion++;
                if (alg3.isSelected()) seleccion++;
                if (alg4.isSelected()) seleccion++;

                if (seleccion == 2) {
                    eleccionAlgoritmo = getEleccionAlgoritmo(alg1, alg2, alg3, alg4);
                    JOptionPane.showMessageDialog(ElegirAlgoritmo, "Algortimos seleccionados correctamente.");
                    ElegirAlgoritmo.setVisible(false);
                    comparar2Estrategias(eleccionAlgoritmo);

                } else {
                    JOptionPane.showMessageDialog(ElegirAlgoritmo, "Por favor, seleccione exactamente dos algoritmos.");
                }
            }
        });
    }
    private static int getEleccionAlgoritmo(JCheckBox alg1, JCheckBox alg2, JCheckBox alg3, JCheckBox alg4) {
        if (alg1.isSelected() && alg2.isSelected()) return 1;
        if (alg1.isSelected() && alg3.isSelected()) return 2;
        if (alg1.isSelected() && alg4.isSelected()) return 3;
        if (alg2.isSelected() && alg3.isSelected()) return 4;
        if (alg2.isSelected() && alg4.isSelected()) return 5;
        if (alg3.isSelected() && alg4.isSelected()) return 6;
        return -1;
    }

    private static Ciudad obtenerCiudadInicial(Grafo grafo) {
        var ciudades = grafo.obtenerCiudades();
        return ciudades.stream()
                .skip(new Random(System.currentTimeMillis()).nextInt(ciudades.size()))
                .findFirst().orElse(null);
    }

}
