package Entidades;

public class Insumo {
    private String nombre;
    private Float cantidad;

    public Insumo(String nombre, Float cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }
}
