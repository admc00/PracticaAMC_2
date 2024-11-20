package org.example;

public class Arista {
    private final Punto x1;
    private final Punto x2;
    private double peso;


    public Arista(Punto x1, Punto x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.peso();

    }

    public Arista() {
        this.x1 = new Punto();
        this.x2 = new Punto();

    }

    public double getPeso() {
        return this.peso;
    }

    private void peso() {
        double pesoX = x1.getX() - x2.getX();
        double pesoY = x1.getY() - x2.getY();
        peso = Math.sqrt(Math.pow(pesoX, 2) + Math.pow(pesoY, 2));
    }

    public Punto getX1() {
        return x1;
    }

    public Punto getX2() {
        return x2;
    }

    @Override
    public String toString() {
        return "Arista{" +
                "x1=" + x1 +
                ", x2=" + x2 +
                ", peso=" + peso +
                '}';
    }
}
