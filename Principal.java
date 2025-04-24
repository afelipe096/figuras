import java.awt.*;
import javax.swing.*;

public class Principal extends JFrame {

    // Arreglo para almacenar las figuras
    private Figura[] listado;

    public Principal() {
        listado = new Figura[6]; // Inicializar el arreglo con 6 figuras

        // Crear triángulos de tipos diferentes
        listado[0] = new Isosceles( // Triángulo rojo
            new Punto2D(-6, 0), new Punto2D(-2, 0), new Punto2D(-4, 4),
            "rojo", "Triángulo Isósceles"
        );
        listado[1] = new Escaleno( // Triángulo naranja
            new Punto2D(2, 0), new Punto2D(7, 0), new Punto2D(5, 5),
            "naranja", "Triángulo Escaleno"
        );
        listado[2] = new TrianguloRectangulo( // Triángulo morado
            new Punto2D(-2, 4), new Punto2D(-2, 1), new Punto2D(1, 1),
            "morado", "Triángulo Rectángulo"
        );

        // Crear cuadriláteros de tipos diferentes
        listado[3] = new Cuadrado( // Cuadrado amarillo
            new Punto2D(-4, -4), new Punto2D(0, -4), new Punto2D(0, 0), new Punto2D(-4, 0),
            "amarillo", "Cuadrado"
        );
        listado[4] = new Rectangulo( // Rectángulo azul
            new Punto2D(1, -4), new Punto2D(6, -4), new Punto2D(6, -2), new Punto2D(1, -2),
            "azul", "Rectángulo"
        );
        listado[5] = new Trapecio( // Trapecio verde
            new Punto2D(-5, -6), new Punto2D(5, -6), new Punto2D(4, -2), new Punto2D(-4, -2),
            "verde", "Trapecio Regular"
        );

        // Imprimir áreas y perímetros de las figuras
        System.out.println("Listado de figuras:");
        System.out.printf("%-20s %-15s %-15s%n", "Figura", "Área", "Perímetro");
        System.out.println("---------------------------------------------------");
        for (Figura f : listado) {
            System.out.printf("%-20s %-15.2f %-15.2f%n",
                f.getDescripcion(), f.area(), f.perimetro()
            );
        }

        // Configurar ventana
        setTitle("Dibujar Figuras");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new PanelFiguras()); // Agregar el panel para dibujar las figuras
        setVisible(true);
    }

    // Clase interna para dibujar las figuras
    class PanelFiguras extends JPanel {

        private double escala = 1; // Escala para ajustar las figuras al panel
        private int offsetX = 0, offsetY = 0; // Desplazamiento para centrar las figuras

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            calcularEscalaYOffsets(); // Calcular escala y desplazamiento antes de dibujar
            for (Figura f : listado) {
                Punto2D[] pts = null;
                if (f instanceof Cuadrilatero) {
                    pts = ((Cuadrilatero) f).getVertices(); // Obtener vértices del cuadrilátero
                }
                if (f instanceof Triangulo) {
                    pts = ((Triangulo) f).getVertices(); // Obtener vértices del triángulo
                }
                if (pts != null) {
                    dibujarPoligono(g, pts, f.getColor()); // Dibujar la figura
                }
            }
        }

        // Calcular escala y desplazamiento para centrar las figuras
        private void calcularEscalaYOffsets() {
            int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

            for (Figura f : listado) {
                Punto2D[] pts = (f instanceof Cuadrilatero) ? ((Cuadrilatero) f).getVertices()
                        : (f instanceof Triangulo) ? ((Triangulo) f).getVertices()
                                : null;

                if (pts == null) {
                    continue;
                }

                for (Punto2D p : pts) {
                    minX = Math.min(minX, p.getX());
                    minY = Math.min(minY, p.getY());
                    maxX = Math.max(maxX, p.getX());
                    maxY = Math.max(maxY, p.getY());
                }
            }

            int boxAncho = maxX - minX;
            int boxAlto = maxY - minY;

            if (boxAncho == 0 || boxAlto == 0) {
                return;
            }

            escala = Math.min(getWidth() * 0.8 / (boxAncho + 1), getHeight() * 0.8 / (boxAlto + 1));
            offsetX = getWidth() / 2 - (int) ((minX + boxAncho / 2.0) * escala);
            offsetY = getHeight() / 2 + (int) ((minY + boxAlto / 2.0) * escala);
        }

        // Dibujar un polígono en el panel
        private void dibujarPoligono(Graphics g, Punto2D[] pts, String colorName) {
            switch (colorName.toLowerCase()) {
                case "amarillo":
                    g.setColor(Color.YELLOW);
                    break;
                case "verde":
                    g.setColor(Color.GREEN);
                    break;
                case "rojo":
                    g.setColor(Color.RED);
                    break;
                case "azul":
                    g.setColor(Color.BLUE);
                    break;
                case "naranja":
                    g.setColor(Color.ORANGE);
                    break;
                case "morado":
                    g.setColor(new Color(128, 0, 128)); // Color personalizado
                    break;
                default:
                    g.setColor(Color.BLACK);
            }

            int n = pts.length;
            int[] xs = new int[n], ys = new int[n];
            for (int i = 0; i < n; i++) {
                xs[i] = (int) (pts[i].getX() * escala + offsetX);
                ys[i] = (int) (-pts[i].getY() * escala + offsetY);
            }
            g.fillPolygon(xs, ys, n); // Dibujar el polígono
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Principal()); // Iniciar la aplicación
    }
}
