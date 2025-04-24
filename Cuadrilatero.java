public abstract class Cuadrilatero extends Figura {
    protected Punto2D[] vertices;

    public Cuadrilatero(Punto2D v1, Punto2D v2, Punto2D v3, Punto2D v4, String color, String descripcion) {
        super(color, descripcion);
        this.vertices = new Punto2D[]{v1, v2, v3, v4};
    }

    public Punto2D[] getVertices() {
        return vertices;
    }
}
