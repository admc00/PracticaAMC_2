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
            g.fillOval((x - 5),(y - 5), 10, 10);

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
