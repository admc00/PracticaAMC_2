package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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


    //@TODO: Importar el resto de clases de Fichero de la prac 1
}
