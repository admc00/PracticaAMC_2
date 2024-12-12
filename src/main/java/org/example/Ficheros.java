package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ficheros {

    public static Grafo leerFichero(String texto) {
        FileReader fr = null;
        BufferedReader br;

        Grafo grafo = new Grafo();

        try {
            String localDir = System.getProperty("user.dir");
            File archivo;

            if (texto.endsWith(".tsp")) {
                archivo = new File(localDir + File.separator + "dataset" + File.separator + texto + File.separator + texto);
            } else {
                archivo = new File(localDir + File.separator + "dataset" + File.separator + texto + File.separator + texto + ".tsp");
            }

            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            var lineas = br.lines().skip(6).toList();

            for (var linea : lineas) {
                if (linea.contains("EOF")) {
                    break;
                }
                String[] parte = linea.split(" ");
                if (parte.length == 3) {
                    grafo.agregarCiudad(new Ciudad(Double.parseDouble(parte[1]), Double.parseDouble(parte[2]), Integer.parseInt(parte[0])));
                }
            }

            var ciudades = grafo.obtenerCiudades();

            for (var ciudad1 : ciudades) {
                for (var ciudad2 : ciudades) {
                    if (ciudad1.getID() != ciudad2.getID()) {
                        Camino camino = new Camino(ciudad1, ciudad2);
                        grafo.agregarCamino(ciudad1, ciudad2, camino);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, "ERROR LEYENDO FICHEROS", ex);
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, "ERROR LEYENDO FICHEROS", e2);
            }
        }
        return grafo;
    }

   public static void crearArchivoTSP(Integer size) {
        File dir, file;
        ArrayList<Ciudad> puntos = new ArrayList<>();
        puntos = RellenarPuntos(size);


        dir = new File(System.getProperty("user.dir") + File.separator + "dataset" + File.separator + "dataset" + size + ".tsp");
        dir.mkdirs();

        file = new File(dir.getPath() + File.separator + "dataset" + size + ".tsp");


        String filePath = file.toString();

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write("NAME: " + ("dataset" + size) + ".tsp");
            writer.newLine();
            writer.write("TYPE: TSP");
            writer.newLine();
            writer.write("COMMENT: " + size + " locations");
            writer.newLine();
            writer.write("DIMENSION: " + size);
            writer.newLine();
            writer.write("EDGE_WEIGHT_TYPE: EUC_2D");
            writer.newLine();
            writer.write("NODE_COORD_SECTION");
            writer.newLine();
            for (int i = 0; i < size; i++) {
                writer.write(i + 1 + " " + puntos.get(i).getX() + " " + puntos.get(i).getY());
                writer.newLine();
            }
            writer.write("EOF");
            writer.newLine();

            //Forzar escritura en el archivo
            writer.flush();
        } catch (IOException e) {
            Logger.getLogger(Ficheros.class.getName()).log(Level.SEVERE, "ERROR ARCHIVOS TSP", e);
        }

    }
    public static ArrayList<Ciudad> RellenarPuntos(int n) {
        ArrayList<Ciudad> p = new ArrayList<>();

        Random rand = new Random();
        rand.setSeed(System.nanoTime());

        int num, den;
        double x, y, aux1;

        for (int i = 0; i < n; i++) {
            num = rand.nextInt(4000) + 1; //genera un número aleatorio entre 1 y 4000
            den = rand.nextInt(11) + 7; //genera un aleatorio entre 7 y 17
            x = num / ((double) den + 0.37); //division con decimales
            y = (rand.nextInt(4000) + 1) / ((double) (rand.nextInt(11) + 7) + 0.37);
            Ciudad pn = new Ciudad(x, y, i + 1);
            p.add(pn);
        }

        return p;
    }


    //@TODO: Importar el resto de clases de Fichero de la prac 1
}
