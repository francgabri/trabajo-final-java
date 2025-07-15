package com.example.demo.controller;

import com.example.demo.entidades.Pedido;
import com.example.demo.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    // ✅ Crear pedido desde carrito
    @PostMapping
    public Pedido crearPedido() {
        return pedidoService.crearPedidoDesdeCarrito();
    }

    // ✅ Ver pedido por ID
    @GetMapping("/{id}")
    public Pedido verPedido(@PathVariable Long id) {
        return pedidoService.obtenerPedido(id);
    }

    // ✅ Ver todos los pedidos
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.listarPedidos();
    }
}
