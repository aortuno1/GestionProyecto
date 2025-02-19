package com.gestion_proyecto.GestionProyecto.model;

public class Producto {

    private static int contador = 1;
    private int idProducto;
    private String nombre;
    private double precio;

    public Producto(){
        this.idProducto = contador++;
    }

    public Producto(int idProducto, String nombre, double precio) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
