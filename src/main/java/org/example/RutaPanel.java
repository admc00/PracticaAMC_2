package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RutaPanel extends JPanel {

    private java.util.List<Ciudad> ciudades;


    public RutaPanel(java.util.List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);

        // Dibujar ciudades
        for (Ciudad ciudad : ciudades) {
            g.fillOval((int) (ciudad.getX() - 5), (int) (ciudad.getY() - 5), 10, 10);

        }

        // Dibujar caminos
        g.setColor(Color.RED);
        for (int i = 0; i < ciudades.size(); i++) {
            Ciudad ciudad = ciudades.get(i);
            Ciudad ciudad2 = ciudades.get((i+1)%ciudades.size());
            g.drawLine((int) ciudad.getX(), (int) ciudad.getY(), (int) ciudad2.getX(), (int) ciudad2.getY());
        }
    }

    public static void mostrarRuta(List<Ciudad> ciudades) {
        JFrame frame = new JFrame("Ruta de Ciudades");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new RutaPanel(ciudades));
        frame.setVisible(true);
    }

}
