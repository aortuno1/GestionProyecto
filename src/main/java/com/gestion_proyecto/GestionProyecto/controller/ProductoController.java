package com.gestion_proyecto.GestionProyecto.controller;

import com.gestion_proyecto.GestionProyecto.model.Producto;
import com.gestion_proyecto.GestionProyecto.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public String Producto(Model model, @ModelAttribute("message") String message) {
        model.addAttribute("message", message);
        model.addAttribute("inventario", productoService.obtenerProductos());
        return "producto";
    }

    @GetMapping("/nuevo")
    public String nuevoProductoForm(Model model) {
        model.addAttribute("producto", new Producto());
        return "nuevoProducto";
    }

    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttributes) {
        productoService.agregarProducto(producto);
        redirectAttributes.addFlashAttribute("guardar", "Contacto guardado");
        return "redirect:/producto";

    }

    @PostMapping("eliminar/{id}")
    public String eliminarContacto(@PathVariable int id, RedirectAttributes redirectAttributes) {
        boolean eliminado = productoService.eliminarProducto(id);
        if(eliminado) {
            redirectAttributes.addFlashAttribute("eliminar", "Contacto eliminado");
        }
        else {
            redirectAttributes.addFlashAttribute("eliminar", "Contacto no eliminado");
        }
        return "redirect:/producto";
    }

    @GetMapping("/editar/{id}")
    public String editarProducto(@PathVariable int id, Model model) {
        Producto producto = productoService.obtenerProductoPorId(id);
        model.addAttribute("contacto", producto);
        return "editarContacto";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizarProducto(@PathVariable int id, Producto producto, RedirectAttributes redirectAttributes) {
        productoService.modificarProducto(id, producto);
        redirectAttributes.addFlashAttribute("actualizar", "Contacto actualizado");
        return "redirect:/producto";
    }

}
