
public class TrianguloRectangulo extends Triangulo {

    public TrianguloRectangulo(Punto2D v1, Punto2D v2, Punto2D v3, String color, String descripcion) {
        super(v1, v2, v3, color, descripcion);
    }

    @Override
    public double area() {
        double base = Punto2D.distancia(vertices[0], vertices[1]);
        double altura = Punto2D.distancia(vertices[1], vertices[2]);
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        return Punto2D.distancia(vertices[0], vertices[1])
                + Punto2D.distancia(vertices[1], vertices[2])
                + Punto2D.distancia(vertices[2], vertices[0]);
    }
}
