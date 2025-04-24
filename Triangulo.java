public abstract class Triangulo extends Figura {
    protected Punto2D[] vertices;

    public Triangulo(Punto2D v1, Punto2D v2, Punto2D v3, String color, String descripcion) {
        super(color, descripcion);
        this.vertices = new Punto2D[]{v1, v2, v3};
    }

    public Punto2D[] getVertices() {
        return vertices;
    }
}
