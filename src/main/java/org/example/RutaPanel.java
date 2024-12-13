package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RutaPanel extends JPanel {

    private java.util.List<Ciudad> ciudades;
    private double escala;

    private void calcularEscala() {
        double maxX = ciudades.stream().mapToDouble(Ciudad::getX).max().orElse(1);
        double maxY = ciudades.stream().mapToDouble(Ciudad::getY).max().orElse(1);
        double panelWidth = getWidth();
        double panelHeight = getHeight();
        escala = Math.min(panelWidth / maxX, panelHeight / maxY);
    }

    public RutaPanel(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
        calcularEscala();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        calcularEscala();
        g.setColor(Color.BLACK);

        // Dibujar ciudades
        for (Ciudad ciudad : ciudades) {
            int x = (int) (ciudad.getX() * escala);
            int y = (int) (ciudad.getY() * escala);
            g.fillOval((x - 5),(y - 5), 20, 20);
            g.setColor(Color.WHITE);
            g.drawString(String.valueOf(ciudad.getID()), x - 1, y + 9);
            g.setColor(Color.BLACK);

        }

        // Dibujar caminos
        g.setColor(Color.RED);
        for (int i = 0; i < ciudades.size(); i++) {
            Ciudad ciudad = ciudades.get(i);
            Ciudad ciudad2 = ciudades.get((i+1)%ciudades.size());
            int x1 = (int) (ciudad.getX() * escala);
            int y1 = (int) (ciudad.getY() * escala);
            int x2 = (int) (ciudad2.getX() * escala);
            int y2 = (int) (ciudad2.getY() * escala);
            g.drawLine(x1, y1, x2, y2);

            // Calcular el punto medio
            int midX = (x1 + x2) / 2;
            int midY = (y1 + y2) / 2;

            g.setColor(Color.BLACK);
            // Dibujar el peso del camino
            Camino c = new Camino(ciudad,ciudad2);// Metodo para calcular el peso entre dos ciudades
            g.drawString(String.format("%.2f", c.getPeso()), midX, midY);
            g.setColor(Color.RED);
        }
    }


    public static void mostrarRuta(List<Ciudad> ciudades, String heuristica) {
        JFrame frame = new JFrame("Ruta de Ciudades " + heuristica);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new RutaPanel(ciudades));
        frame.setVisible(true);
    }

}
