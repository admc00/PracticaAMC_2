package org.example;

public class Punto {

    private double x;
    private double y;
    private int id;

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

    public void setX(float x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getID() {
        return (float) this.id;
    }

    public void setID(int id) {
        this.id = id;
    }
}
