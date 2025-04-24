public class Isosceles extends Triangulo {
    public Isosceles(Punto2D v1, Punto2D v2, Punto2D v3, String color, String descripcion) {
        super(v1, v2, v3, color, descripcion);
    }

    @Override
    public double area() {
        double base = Punto2D.distancia(vertices[0], vertices[1]);
        double altura = Punto2D.distancia(vertices[2], new Punto2D((vertices[0].getX() + vertices[1].getX()) / 2, vertices[2].getY()));
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        return Punto2D.distancia(vertices[0], vertices[1]) +
               2 * Punto2D.distancia(vertices[0], vertices[2]);
    }
}
