public class Cuadrado extends Cuadrilatero {
    public Cuadrado(Punto2D v1, Punto2D v2, Punto2D v3, Punto2D v4, String color, String descripcion) {
        super(v1, v2, v3, v4, color, descripcion);
    }

    @Override
    public double area() {
        double lado = Punto2D.distancia(vertices[0], vertices[1]);
        return lado * lado;
    }

    @Override
    public double perimetro() {
        double lado = Punto2D.distancia(vertices[0], vertices[1]);
        return 4 * lado;
    }
}
