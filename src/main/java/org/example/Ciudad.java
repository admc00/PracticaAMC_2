package org.example;

public class Ciudad {

    //Coordenadas de la ciudad
    private final double x, y;
    private final int id;

    //Indica si la ciudad ha sido visitada
    private Boolean visitada = false;

    public Ciudad(double x, double y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public Ciudad() {
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

    public int getID() {
        return this.id;
    }

    /**
     * Comprobar si una ciudad esta visitada.
     *
     * @return Un booleano en funcion de si esta visitada o no.
     */
    public Boolean esVisitada() {
        return this.visitada;
    }

    public void setVisitada(Boolean visitada) {
        this.visitada = visitada;
    }

    @Override
    public String toString() {
        return "id: " + this.id + ", x: " + this.x + ", y: " + this.y + ", visitada: " + this.visitada;
    }
}
