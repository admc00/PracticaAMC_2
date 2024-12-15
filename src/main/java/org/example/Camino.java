package org.example;

public class Camino {
    private final Ciudad c1, c2;
    private final double peso;


    public Camino(Ciudad c1, Ciudad c2) {
        this.c1 = c1;
        this.c2 = c2;
        peso = calcularPeso();
    }

    public Camino(Camino camino) {
        c1 = camino.getC1();
        c2 = camino.getC2();
        peso = camino.getPeso();
    }

    public Camino() {
        c1 = new Ciudad();
        c2 = new Ciudad();
        peso = 0;
    }

    private double calcularPeso() {
        double pesoX = c1.getX() - c2.getX();
        double pesoY = c1.getY() - c2.getY();
        return Math.sqrt(Math.pow(pesoX, 2) + Math.pow(pesoY, 2));
    }

    public double getPeso() {
        return peso;
    }

    public Ciudad getC1() {
        return c1;
    }

    public Ciudad getC2() {
        return c2;
    }

    @Override
    public String toString() {
        return "\n\t\t" +
                "Camino{" +
                "c1=" + c1 +
                ", c2=" + c2 +
                ", peso=" + peso +
                "}";
    }
}
