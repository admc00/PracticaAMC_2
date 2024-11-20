package org.example;

public class Punto {

    private final double x;
    private final double y;
    private final int id;
    private Boolean visitado = false;

    public Punto(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public Punto() {
        this.x = 0.0;
        this.y = 0.0;
        this.id = 0;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public float getID() {
        return (float) this.id;
    }

    public Boolean getVisitado() {
        return this.visitado;
    }
    public void setVisitado(Boolean visitado) {
        this.visitado = visitado;
    }

}
