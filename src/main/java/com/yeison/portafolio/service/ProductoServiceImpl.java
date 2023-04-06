package com.yeison.portafolio.service;

import com.yeison.portafolio.modells.Producto;
import com.yeison.portafolio.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto create(Producto producto) {
        Long idNext = this.getAll().spliterator().getExactSizeIfKnown();
        producto.setIdPropucto(idNext + 1);
        return this.productoRepository.save(producto);
    }

    @Override
    public Optional findById(Long idProducto) {
        Optional<Producto> productoExistente = this.productoRepository.findById(idProducto);
        return productoExistente;
    }

    @Override
    public Producto update(Producto producto) {
        Optional<Producto> productExistente = this.findById(producto.getIdPropucto());
        if(productExistente != null){
            productExistente.get().setNombreProducto(producto.getNombreProducto());
            productExistente.get().setPrecio(producto.getPrecio());
            productExistente.get().setStock(producto.getStock());
            this.productoRepository.save(productExistente.get());
            return productExistente.get();
        }
        return null;
    }

    @Override
    public void deleteById(Long id) {
        this.productoRepository.deleteById(id);
        this.changeId();
    }

    @Override
    public Iterable<Producto> getAll(){
        return this.productoRepository.findAll();
    }

    public void changeId(){
        Long count = Long.valueOf(1);
        Iterable<Producto> updateProducts = this.getAll();
        this.productoRepository.deleteAll();
        for (Producto product: updateProducts) {
            product.setIdPropucto(count);
            count++;
            this.productoRepository.save(product);
        }
    }
}
