package com.example.demo.controller;

import com.example.demo.entidades.ItemCarrito;
import com.example.demo.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // ✅ Ver carrito
    @GetMapping
    public List<ItemCarrito> verCarrito() {
        return carritoService.obtenerCarrito();
    }

    // ✅ Agregar producto al carrito
    @PostMapping("/agregar")
    public ItemCarrito agregar(@RequestParam Long productoId, @RequestParam int cantidad) {
        return carritoService.agregarAlCarrito(productoId, cantidad);
    }

    // ✅ Eliminar ítem del carrito
    @DeleteMapping("/eliminar/{itemId}")
    public void eliminar(@PathVariable Long itemId) {
        carritoService.eliminarDelCarrito(itemId);
    }

    // ✅ Vaciar carrito
    @DeleteMapping("/vaciar")
    public void vaciarCarrito() {
        carritoService.vaciarCarrito();
    }
}
