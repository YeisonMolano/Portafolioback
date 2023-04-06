package com.yeison.portafolio.controller;

import com.yeison.portafolio.modells.Producto;
import com.yeison.portafolio.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Producto> getAll(){
        return this.productoService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto newProducto(@RequestBody Producto producto){
        return this.productoService.create(producto);
    }

    @GetMapping(value = "/{idProducto}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Producto> getById(@PathVariable(value = "idProducto") Long idProducto){
        return this.productoService.findById(idProducto);
    }

    @PutMapping(value = "/{idProducto}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Producto update(@RequestBody Producto producto){
        return this.productoService.update(producto);
    }

    @PostMapping(value = "/{idProducto}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable(value = "idProducto") Long idProducto){
        this.productoService.deleteById(idProducto);
    }
}
