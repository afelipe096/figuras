public class Escaleno extends Triangulo {
    public Escaleno(Punto2D v1, Punto2D v2, Punto2D v3, String color, String descripcion) {
        super(v1, v2, v3, color, descripcion);
    }

    @Override
    public double area() {
        double a = Punto2D.distancia(vertices[0], vertices[1]);
        double b = Punto2D.distancia(vertices[1], vertices[2]);
        double c = Punto2D.distancia(vertices[2], vertices[0]);
        double s = (a + b + c) / 2.0;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public double perimetro() {
        return Punto2D.distancia(vertices[0], vertices[1]) +
               Punto2D.distancia(vertices[1], vertices[2]) +
               Punto2D.distancia(vertices[2], vertices[0]);
    }
}
