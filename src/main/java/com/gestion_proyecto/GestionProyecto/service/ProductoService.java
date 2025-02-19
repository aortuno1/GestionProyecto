package com.gestion_proyecto.GestionProyecto.service;

import com.gestion_proyecto.GestionProyecto.model.Producto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductoService {
    private Map<Integer, Producto> productos = new HashMap<>();

    public Map<Integer, Producto> obtenerProductos() {
        return productos;
    }

    public void agregarProducto(Producto producto) {
        if (!productos.containsKey(producto.getIdProducto())) {
            productos.put(producto.getIdProducto(), producto);
            System.out.println("Producto agregado: " + producto.getNombre());
        } else {
            System.out.println("El producto con ID " + producto.getIdProducto() + " ya existe.");
        }
    }

    public void modificarProducto(int idProducto, Producto product) {
        Producto producto = productos.get(product.getIdProducto());
        if (producto != null) {
            producto = new Producto(idProducto, producto.getNombre(), producto.getPrecio());
            productos.put(idProducto, producto);
            System.out.println("Producto modificado: " + producto.getNombre());
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
        }
    }

    public boolean eliminarProducto(int idProducto) {
        Producto producto = productos.remove(idProducto);
        if (producto != null) {
            System.out.println("Producto eliminado: " + producto.getNombre());
            return true;
        } else {
            System.out.println("Producto con ID " + idProducto + " no encontrado.");
            return false;
        }
    }

    public Producto obtenerProductoPorId(int idProducto) {
        if(productos.containsKey(idProducto))
            return productos.get(idProducto);
        return null;
    }
}