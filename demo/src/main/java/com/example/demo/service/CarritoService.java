package com.example.demo.service;

import com.example.demo.entidades.ItemCarrito;
import com.example.demo.entidades.Producto;
import com.example.demo.repository.ItemCarritoRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<ItemCarrito> obtenerCarrito() {
        return itemCarritoRepository.findAll();
    }

    public ItemCarrito agregarAlCarrito(Long productoId, int cantidad) {
        Producto producto = productRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        ItemCarrito item = new ItemCarrito();
        item.setProducto(producto);
        item.setCantidad(cantidad);
        return itemCarritoRepository.save(item);
    }

    public void eliminarDelCarrito(Long itemId) {
        itemCarritoRepository.deleteById(itemId);
    }

    public void vaciarCarrito() {
        itemCarritoRepository.deleteAll();
    }
}
