public class Rectangulo extends Cuadrilatero {
    public Rectangulo(Punto2D v1, Punto2D v2, Punto2D v3, Punto2D v4, String color, String descripcion) {
        super(v1, v2, v3, v4, color, descripcion);
    }

    @Override
    public double area() {
        double base = Punto2D.distancia(vertices[0], vertices[1]);
        double altura = Punto2D.distancia(vertices[1], vertices[2]);
        return base * altura;
    }

    @Override
    public double perimetro() {
        double base = Punto2D.distancia(vertices[0], vertices[1]);
        double altura = Punto2D.distancia(vertices[1], vertices[2]);
        return 2 * (base + altura);
    }
}
