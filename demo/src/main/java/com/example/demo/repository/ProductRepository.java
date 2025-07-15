package com.example.demo.repository;

import com.example.demo.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Producto, Long> {
    // Podés agregar métodos personalizados si querés, por ejemplo:
    // List<Producto> findByNombre(String nombre);
}
