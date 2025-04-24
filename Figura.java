public abstract class Figura {
    protected String color;
    protected String descripcion;

    public Figura() { }

    public Figura(String color, String descripcion) {
        this.color = color;
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract double area();
    public abstract double perimetro();
}
