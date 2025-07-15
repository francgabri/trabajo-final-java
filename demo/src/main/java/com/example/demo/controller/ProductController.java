package com.example.demo.controller;

import com.example.demo.entidades.Producto;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // ✅ Mostrar todos los productos
    @GetMapping
    public List<Producto> listarProductos() {
        return productRepository.findAll();
    }

    // ✅ Agregar nuevo producto
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productRepository.save(producto);
    }

    // ✅ Actualizar producto
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        Optional<Producto> optional = productRepository.findById(id);
        if (optional.isPresent()) {
            Producto producto = optional.get();
            producto.setNombre(productoActualizado.getNombre());
            producto.setPrecio(productoActualizado.getPrecio());
            producto.setStock(productoActualizado.getStock());
            return productRepository.save(producto);
        } else {
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }

    // ✅ Eliminar producto
    @DeleteMapping("/{id}")
    public void eliminarProducto(@PathVariable Long id) {
        productRepository.deleteById(id);
    }
}
