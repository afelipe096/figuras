public class Trapecio extends Cuadrilatero {
    public Trapecio(Punto2D v1, Punto2D v2, Punto2D v3, Punto2D v4, String color, String descripcion) {
        super(v1, v2, v3, v4, color, descripcion);
    }

    @Override
    public double area() {
        double baseMayor = Punto2D.distancia(vertices[0], vertices[1]);
        double baseMenor = Punto2D.distancia(vertices[2], vertices[3]);
        double altura = Punto2D.distancia(vertices[1], vertices[2]);
        return (baseMayor + baseMenor) * altura / 2;
    }

    @Override
    public double perimetro() {
        return Punto2D.distancia(vertices[0], vertices[1]) +
               Punto2D.distancia(vertices[1], vertices[2]) +
               Punto2D.distancia(vertices[2], vertices[3]) +
               Punto2D.distancia(vertices[3], vertices[0]);
    }
}
