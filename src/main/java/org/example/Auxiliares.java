package org.example;

import javax.swing.*;
import java.awt.*;

public class Auxiliares {

    private static Grafo g;

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
            g = Ficheros.leerFichero("berlin52.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch130 = new JButton("Ch130");
        ch130.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("ch130.tsp");
            g = Ficheros.leerFichero("ch130.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton ch150 = new JButton("Ch150");
        ch150.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("ch150.tsp");
            g = Ficheros.leerFichero("ch150.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d493 = new JButton("d493");
        d493.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("d493.tsp");
            g = Ficheros.leerFichero("d493.tsp");
            nuevaVentana.setVisible(false);
            Menu();
        });
        JButton d657 = new JButton("d657");
        d657.addActionListener(e -> {
            // Código a ejecutar cuando se haga clic en el botón
            Ficheros.leerFichero("d657.tsp");
            g = Ficheros.leerFichero("d657.tsp");
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

        double costeMinimoEXU = BusquedaVorazExhausitvaUni.costeMinimo(g);
        //double costeMinimoEXB = BusquedaVorazExhaustivaBi.costeMinimo(g);
        double costeMinimoPOU = BusquedaVorazPodaUni.costeMinimo(g);
        //double costeMinimoPOB = BusquedaVorazPodaBi.costeMinimo(g);

        String[] columnNames = {"Estrategia", "Solución", "Calculadas", "Tiempo (mseg)"};
        Object[][] data = {
                    {"Unidireccional exhaustivo",costeMinimoEXU, 8386, 0.1679},
                    {"Bidireccional exhaustivo",0, 12249, 0.2317},
                    {"Unidireccional con poda",costeMinimoPOU, 2386, 0.1479},
                    {"Bidireccional con poda",0, 2947, 0.1571}
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

}
