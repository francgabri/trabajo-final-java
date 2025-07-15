package com.example.demo.service;

import com.example.demo.entidades.ItemCarrito;
import com.example.demo.entidades.Pedido;
import com.example.demo.repository.ItemCarritoRepository;
import com.example.demo.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ItemCarritoRepository carritoRepository;

    public Pedido crearPedidoDesdeCarrito() {
        List<ItemCarrito> carrito = carritoRepository.findAll();
        if (carrito.isEmpty()) {
            throw new RuntimeException("El carrito está vacío.");
        }

        Pedido pedido = new Pedido();
        pedido.setFecha(LocalDate.now());
        pedido.setItems(carrito);
        Pedido pedidoGuardado = pedidoRepository.save(pedido);

        // Vaciar el carrito
        carritoRepository.deleteAll();

        return pedidoGuardado;
    }

    public Pedido obtenerPedido(Long id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }

    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
}
