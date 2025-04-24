public class Punto2D {
    private int x, y;

    public Punto2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double distancia(Punto2D other) {
        int dx = other.x - this.x;
        int dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distancia(Punto2D p1, Punto2D p2) {
        return p1.distancia(p2);
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}
