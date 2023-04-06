package com.yeison.portafolio.service;

import com.yeison.portafolio.modells.Producto;

import java.util.Optional;

public interface ProductoService {
    Producto create(Producto producto);
    Optional findById(Long idProducto);
    Producto update(Producto producto);
    void deleteById(Long id);

    Iterable<Producto> getAll();
}
